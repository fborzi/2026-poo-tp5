# Trabajo Práctico: Persistencia, NIO.2 y Transacciones JDBC

Guía de ejercicios avanzados para la materia **Desarrollo de Sistemas Orientado a Objetos**.

Los siguientes ejercicios integran conceptos fundamentales de la Programación Orientada a Objetos en un contexto empresarial real: manejo de archivos con la API moderna de Entrada/Salida (Java NIO.2), acceso a bases de datos relacionales mediante JDBC puro con el patrón DAO, y procesamiento por lotes con control estricto de transacciones ACID.

---

## Criterios Generales de Diseño y Arquitectura

Para todos los ejercicios se exige aplicar buenas prácticas de diseño de software:
* **Estructura modular por paquetes:** no concentrar toda la lógica en una única clase. Organizar cada ejercicio en subpaquetes según su responsabilidad (`model`, `service`, `dao`, `exception`, `config`).
* **Encapsulamiento y tipado:** utilizar los tipos de datos adecuados de Java (por ejemplo, `BigDecimal` para valores monetarios, `Instant` / `LocalDate` para marcas temporales y fechas, `Optional` para valores que pueden no existir).
* **Gestión rigurosa de recursos:** todo descriptor de archivos, flujo de I/O y recurso de base de datos (`Connection`, `PreparedStatement`, `ResultSet`, `BufferedReader`, `BufferedWriter`) debe cerrarse de forma segura y garantizada mediante sentencias `try-with-resources`.
* **Desacoplamiento de excepciones:** las capas de negocio no deben quedar atadas a detalles de infraestructura. Se deben encapsular errores de bajo nivel (`IOException`, `SQLException`) en excepciones propias del dominio.

---

## Ejercicio 2507: Bitácora Forense de Operaciones (`FileAuditorService`)

### Contexto y Demanda
La compañía exige una bitácora forense que registre cada evento crítico del sistema en el disco local del servidor, de modo que la trazabilidad de operaciones sea independiente del estado de conectividad con el motor de base de datos.
Se demanda desarrollar el componente `FileAuditorService` encargado de interceptar y registrar las operaciones realizadas por los usuarios.

### Especificaciones Técnicas y Arquitectura Esperada
Para asegurar la separación de conceptos y la extensibilidad del sistema, modele la solución distribuyendo responsabilidades:
1. **Capa de Modelo (`model`):**
   * Diseñe una clase de dominio (e.g. `AuditEvent` o `EventoAuditoria`) que represente el evento a auditar con su información fundamental: momento exacto del hecho, sesión de usuario, acción realizada y detalle operativo.
   * La clase debe responsabilizarse del formateo estricto exigido por la empresa.
2. **Capa de Servicio (`service`):**
   * Defina un contrato de interfaz (e.g. `AuditorService`) que exponga los métodos de registro de operaciones.
   * Implemente la clase concreta `FileAuditorService` aplicando la API moderna **Java NIO.2** (`java.nio.file.*`).
3. **Capa de Excepciones (`exception`):**
   * Diseñe excepciones personalizadas para encapsular y reportar fallos de auditoría en caso de anomalías en el sistema de almacenamiento.

### Requisitos del Registro y Sistema de Archivos
* **Estructura de directorios:** los archivos de auditoría deben ubicarse dentro de la ruta `var/log/`. La aplicación debe verificar la existencia del directorio y crearlo de forma desatendida si no existe en el disco (`Files.createDirectories`).
* **Archivo de log:** las operaciones deben asentarse en el archivo `auditoria_operaciones.log`.
* **Modo de apertura:** cada nuevo evento debe anexarse al final del archivo sin sobreescribir el historial existente (`StandardOpenOption.CREATE` y `StandardOpenOption.APPEND`).
* **Formato obligatorio por línea de log:**
  ```plaintext
  [TIMESTAMP_ISO_8601] | [USER_SESSION] | [ACCION] | [DETALLE_OPERACION]
  ```
  *(Investigar el uso de `java.time.Instant` o `DateTimeFormatter.ISO_INSTANT` para garantizar el estándar internacional ISO-8601).*
* **Cierre seguro:** control estricto de excepciones de Entrada/Salida (`IOException`) con cierre seguro de descriptores de archivos mediante `try-with-resources`.

---

## Ejercicio 2508: Módulo de Acceso a Datos de Bajo Nivel (`ProductoDAO` con JDBC Puro)

### Contexto y Demanda
Para erradicar la manipulación desordenada de tablas y asegurar la integridad de datos, la empresa exige construir un módulo de acceso a datos de bajo nivel para la entidad `Producto`, sirviendo de base técnica previa a futuros frameworks de persistencia de alto nivel (como JPA o Hibernate).
Se demanda diseñar la interfaz de contrato `ProductoDAO` y su implementación concreta `ProductoDAOImpl` utilizando **JDBC puro (`java.sql.*`)**.

### Modelo Relacional Requerido
La tabla `productos` debe responder al siguiente esquema:
* `id` (`INT` / `BIGINT`, Autoincremental, Primary Key).
* `codigo_sku` (`VARCHAR`, Único, No nulo).
* `descripcion` (`VARCHAR`, No nulo).
* `precio_unitario` (`DECIMAL` / `NUMERIC`, No nulo).
* `stock_disponible` (`INT`, No nulo).

### Estructura de Paquetes y Responsabilidades
1. **Entidad de Dominio (`model`):**
   * Clase `Producto` que modele los campos de la tabla con tipos Java idiomáticos (`Long` para identificadores, `BigDecimal` para el precio monetario, `Integer` para stock, etc.).
2. **Capa de Acceso a Datos (`dao`):**
   * Interfaz de contrato `ProductoDAO` que declare las operaciones CRUD estándar:
     * `guardar(Producto producto)`: persiste la entidad y le asigna la clave primaria autogenerada (`Statement.RETURN_GENERATED_KEYS`).
     * `buscarPorId(Long id)`: búsqueda por clave primaria (considere el uso de `Optional<Producto>` para evitar retornos nulos).
     * `buscarPorSku(String sku)`: búsqueda por clave alternativa única de negocio.
     * `listarTodos()`: recuperación de la totalidad del catálogo.
     * `actualizarStock(Long id, Integer nuevoStock)`: modificación del inventario disponible.
     * `eliminar(Long id)`: baja física del registro.
   * Clase de implementación `ProductoDAOImpl` con JDBC puro.
3. **Manejo de Errores (`exception`):**
   * Diseñe una excepción propia (e.g. `DAOException`) que encapsule cualquier `SQLException`.
4. **Infraestructura (`config`):**
   * Proveer un mecanismo desacoplado para suministrar instancias de `Connection` a la capa DAO (mediante interfaces funcionales, fábricas de conexión o credenciales configurables).

### Reglas Técnicas y de Seguridad Obligatorias
* **Regla de seguridad estricta (Prevención de SQL Injection):** todas las consultas y modificaciones deben ejecutarse **exclusivamente mediante `PreparedStatement` parametrizados (`?`)**. Queda terminantemente prohibida la concatenación de cadenas en sentencias SQL.
* **Conversión obligatoria de datos (Mapeo ORM manual):** el cursor devuelto (`ResultSet`) debe ser encapsulado y transformado inmediatamente a instancias de la clase de dominio `Producto`. No se debe propagar ningún objeto de `java.sql.*` hacia las capas superiores.
* **Gestión de recursos:** la adquisición y liberación de `Connection`, `PreparedStatement` y `ResultSet` debe gestionarse de forma inequívoca con `try-with-resources`.

---

## Ejercicio 2509: Procesamiento por Lotes y Transacciones ACID (`StockBatchProcessor`)

### Contexto y Demanda
El sistema legado del centro logístico emite periódicamente un archivo plano con las novedades de artículos, y la casa central requiere un archivo de corte para reportes externos.
Se demanda desarrollar el servicio `StockBatchProcessor` que opere como puente de integración entre el sistema de archivos del servidor y la base de datos relacional.

### Organización Arquitectónica Sugerida
* **`model`:** clase representativa del registro de artículo para los lotes (e.g. `ArticuloStock`).
* **`service`:** clase de servicio `StockBatchProcessor` encargada de coordinar los flujos I/O y las transacciones de base de datos.
* **`exception`:** excepción especializada (e.g. `BatchProcessingException`) que permita reportar la causa exacta del fallo y el número de línea del archivo donde se produjo el error.
* **`config`:** componentes de conexión a base de datos reutilizables o parametrizables.

### Flujos Operativos a Implementar

#### Flujo 1: Exportación Masiva (DB -> CSV)
* Extraer el inventario de la base de datos y generar un archivo delimitado por comas dentro de la carpeta `exports/` (creando la carpeta si no existe).
* El archivo debe nombrarse con el patrón:
  ```plaintext
  exports/inventario_consolidado_[FECHA].csv
  ```
  *(donde `[FECHA]` corresponde a la fecha actual o la fecha provista en formato `yyyy-MM-dd`).*
* El archivo generado debe contener el encabezado estándar:
  ```csv
  SKU,DESCRIPCION,PRECIO,STOCK
  ```
  seguido por los registros correspondientes formateados de manera limpia.

#### Flujo 2: Importación Transaccional con Manejo de Errores (CSV -> DB)
* Leer y procesar el archivo de novedades ubicado en `imports/lote_ingresos.csv`.
* **Atomicidad (Principio ACID):** la inserción de la totalidad de las filas del lote debe ejecutarse bajo una **transacción controlada explícitamente**. Se debe desactivar el modo de autoconfirmación de la conexión (`conn.setAutoCommit(false)`).
* **Confirmación exitosa (`commit`):** si la totalidad de los registros del archivo es válida, el lote debe impactar definitivamente en la base de datos mediante `conn.commit()`.
* **Reversión total (`rollback`):**
  * Si una sola línea del archivo contiene errores de parsing (como cantidades incorrectas de columnas, tipos alfanuméricos en campos numéricos o precios/stocks negativos);
  * O si durante la inserción en la base de datos se produce una violación de integridad (por ejemplo, un `codigo_sku` duplicado que viole la restricción única);
  * **El lote entero debe ser revertido inmediatamente mediante `conn.rollback()`**. Ningún registro parcial puede quedar guardado en la base de datos (todo o nada).
* **Bitácora de fallos de importación:** en caso de producirse un rollback, el servicio debe registrar de inmediato una entrada en el archivo `var/log/fallos_importacion.log` (creando los directorios necesarios si no existen) detallando:
  * La marca temporal del evento.
  * El número de línea exacto del archivo CSV que originó el rechazo del lote.
  * La causa puntual de la falla (error de validación, formato corrupto o conflicto de base de datos).
