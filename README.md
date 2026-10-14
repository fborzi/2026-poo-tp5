# 2026-poo-tp5

Repositorio educativo para la materia **Desarrollo de Sistemas Orientado a Objetos** con la finalidad de poner en práctica la teoría vista en clase.

---

## <i>Trabajo Práctico 5: Persistencia, NIO.2 y Transacciones JDBC</i>

### Requisitos:
- Tener instalado Java 25.
- Tener instalado Maven.
- Tener instalado un IDE como IntelliJ IDEA.
- Tener instalado Git en su máquina local.
- Tener instalado Git Bash.
- Tener una cuenta en GitHub.
- Solicitar acceso de escritura al repositorio mediante su usuario.
- Trabajar dentro de la carpeta `/src` del repositorio clonado.

### Objetivos:
- Poner en práctica los conceptos de Programación Orientada a Objetos en un contexto empresarial.
- Trabajar con la API de Entrada/Salida de archivos (**Java NIO.2**).
- Implementar persistencia en bases de datos relacionales mediante **JDBC puro** y el patrón **DAO**, asegurando consultas seguras mediante `PreparedStatement`.
- Administrar transacciones de base de datos con control estricto de propiedades **ACID** (`commit` y `rollback`).
- Trabajar con Git y GitHub llevado a un entorno real.
- Escribir código según las convenciones de Java (Checkstyle) y aplicar la documentación correspondiente.

---

### Formato de trabajo:

#### En GitHub:
1. Solicitar acceso de escritura al repositorio mediante su usuario.
2. Crear una rama nueva a partir de la rama `main` con el siguiente formato:
   - `feature/<apellido-nombre>`. Por ejemplo: `feature/borzi-franco`.

#### En su máquina local:
1. Elegir la carpeta donde se va a trabajar y por consiguiente clonar el repositorio:
   - Por ejemplo: `C:\Users\francoborzi\Documents\TecnicaturaSoftware\segundo\poo\tp5`.
2. Abrir Git Bash en la carpeta elegida:
   - *Dentro de la carpeta, hacer clic derecho y seleccionar "Git Bash Here".*
3. Ejecutar los siguientes comandos en Git Bash:
   - Clonar el repositorio en su máquina local:
     ```bash
     git clone https://github.com/fborzi/2026-poo-tp5.git
     ```
   - Entrar al repositorio:
     ```bash
     cd 2026-poo-tp5
     ```
   - Moverse a la rama feature creada anteriormente:
     ```bash
     git checkout feature/<apellido-nombre>
     ```
4. Abrir la carpeta del repositorio clonado con el IDE (IntelliJ IDEA).
5. Trabajar dentro de la carpeta `/src` del repositorio clonado.

#### Modo de trabajo con Git:
Al finalizar la resolución de cada ejercicio, se deberá:
1. Guardar los cambios realizados en los archivos.
2. Abrir Git Bash en la carpeta del repositorio clonado.
3. Ejecutar los siguientes comandos en Git Bash:
   - `git status` para verificar los archivos modificados.
   - `git add .` para agregar todos los archivos modificados.
   - `git commit -m "tipo: Mensaje descriptivo del commit"` para crear un commit con los cambios realizados. **Es importante explicar brevemente de qué va el ejercicio, evitando colocar commits genéricos como "Ejercicio resuelto" o similares.**
   - `git push origin feature/<apellido-nombre>` para subir los cambios a la rama feature en GitHub.
4. Estos pasos se deberán seguir para cada ejercicio resuelto.

---

### Formato de entrega:
Para cumplir con la entrega del TP5, se deberá:
- Finalizar la resolución de todos los ejercicios propuestos.
- Asegurarse de que todos los cambios estén subidos a la rama feature en GitHub.
- Verificar que el código pase correctamente las evaluaciones automáticas hechas en **GitHub Actions**:
  - Compilación sin errores (`mvn clean install -DskipTests`).
  - Verificación de estilo y buenas prácticas con **Checkstyle**.

---

## El trabajo se aprueba con un 60%

### Criterios de evaluación:
- **Compilación y ejecución:** se evaluará el correcto funcionamiento del código mediante comprobaciones automáticas en GitHub Actions.
- **Seguridad y buenas prácticas:**
  - Uso estricto de `PreparedStatement` para prevenir inyecciones SQL.
  - Cierre seguro de descriptores y recursos con `try-with-resources`.
  - Manejo adecuado de transacciones (todo o nada en lotes).
- **Convenciones y estilo:** se evaluará el cumplimiento de las normas de estilo de Java y la documentación mediante Checkstyle.
- **Historial de Git:** se evaluará que los commits tengan mensajes descriptivos, claros y progresivos.
- **Puntualidad:** se evaluará que el trabajo haya sido entregado en la fecha pautada.

---

## Criterios Generales de Diseño y Arquitectura

Para todos los ejercicios se exige aplicar buenas prácticas de diseño de software:
* **Estructura modular por paquetes:** no concentrar toda la lógica en una única clase. Organizar cada ejercicio en subpaquetes según su responsabilidad (`model`, `service`, `dao`, `exception`, `config`).
* **Encapsulamiento y tipado:** utilizar los tipos de datos adecuados de Java (por ejemplo, `BigDecimal` para valores monetarios, `Instant` / `LocalDate` para marcas temporales y fechas, `Optional` para valores que pueden no existir).
* **Gestión rigurosa de recursos:** todo descriptor de archivos, flujo de I/O y recurso de base de datos (`Connection`, `PreparedStatement`, `ResultSet`, `BufferedReader`, `BufferedWriter`) debe cerrarse de forma segura y garantizada mediante sentencias `try-with-resources`.
* **Desacoplamiento de excepciones:** las capas de negocio no deben quedar atadas a detalles de infraestructura. Se deben encapsular errores de bajo nivel (`IOException`, `SQLException`) en excepciones propias del dominio.

---