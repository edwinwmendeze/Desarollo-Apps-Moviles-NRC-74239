# PA1 - Aplicación de Cálculos Matemáticos

## Información del Estudiante
- **Estudiante:** Edwin Wladimir Mendez
- **Curso:** Desarrollo de Aplicaciones Móviles
- **NRC:** 74239
- **Profesor:** [Nombre del Profesor]

## Descripción del Proyecto
Aplicación Android desarrollada con Navigation Drawer que implementa 5 funcionalidades matemáticas principales:

1. **Cálculo de Área de Triángulo**
   - Implementa la fórmula de Herón
   - Validación de triángulos válidos
   - Entrada: 3 lados del triángulo
   - Salida: Área en cm²

2. **Generador de Número Aleatorio**
   - Genera números de 6 dígitos
   - Valida que contenga exactamente 3 dígitos impares
   - Regenera automáticamente hasta cumplir condición

3. **Conversión Binario a Decimal**
   - Convierte números binarios a decimales
   - Validación de entrada (solo 0 y 1)
   - Algoritmo usando potencias de 2

4. **Conversión Hexadecimal a Binario**
   - Convierte números hexadecimales a binarios
   - Soporte para dígitos 0-9 y A-F
   - Conversión dígito por dígito

5. **Acerca de**
   - Información personal del desarrollador
   - Detalles del curso y proyecto

## Características Técnicas

### Arquitectura
- **Patrón:** Navigation Drawer Activity
- **Componentes:** Fragments para cada funcionalidad
- **Navegación:** Navigation Component de Android

### UI/UX
- **Splash Screen:** Animación de fade-in con logo
- **Tema Personalizado:** Colores corporativos y estilos consistentes
- **Responsive Design:** Layouts adaptativos para diferentes pantallas
- **Material Design:** Siguiendo las guías de diseño de Google

### Funcionalidades Implementadas
- Validación de entrada de datos
- Mensajes de error informativos con Toast
- Navegación fluida entre fragments
- Animaciones de transición
- Manejo de estados de la aplicación

## Instalación y Ejecución

### Requisitos Previos
- Android Studio Arctic Fox o superior
- Android SDK 24 (API Level 24) o superior
- JDK 8 o superior

### Pasos de Instalación
1. Clonar el repositorio:
   ```bash
   git clone [URL_DEL_REPOSITORIO]
   ```

2. Abrir el proyecto en Android Studio:
   - File -> Open -> Seleccionar carpeta `mendez_pa1`

3. Sincronizar el proyecto:
   - Click en "Sync Now" cuando aparezca la notificación

4. Ejecutar la aplicación:
   - Conectar dispositivo Android o iniciar emulador
   - Click en Run (botón verde) o Shift+F10

## Estructura del Proyecto

```
mendez_pa1/
├── app/
│   ├── src/main/
│   │   ├── java/mendez/pa1/org/
│   │   │   ├── MainActivity.java
│   │   │   ├── SplashActivity.java
│   │   │   └── ui/
│   │   │       ├── areatriangulo/
│   │   │       ├── numeroaleatorio/
│   │   │       ├── binariodecimal/
│   │   │       ├── hexbinario/
│   │   │       └── acerca/
│   │   ├── res/
│   │   │   ├── layout/ (layouts XML)
│   │   │   ├── values/ (colores, strings, estilos)
│   │   │   ├── navigation/ (navigation graph)
│   │   │   └── drawable/ (recursos gráficos)
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts
├── gradle/
└── build.gradle.kts
```

## Tecnologías Utilizadas
- **Lenguaje:** Java
- **Framework:** Android SDK
- **Arquitectura:** MVVM con Navigation Component
- **UI:** Material Design Components
- **Build System:** Gradle con Kotlin DSL

## Funciones Matemáticas Implementadas

### Fórmula de Herón
```java
double semiperimetro = (lado1 + lado2 + lado3) / 2;
double area = Math.sqrt(semiperimetro * (semiperimetro - lado1) * 
                       (semiperimetro - lado2) * (semiperimetro - lado3));
```

### Conversión Binario a Decimal
```java
for (int i = 0; i < binario.length(); i++) {
    char bit = binario.charAt(binario.length() - 1 - i);
    if (bit == '1') {
        decimal += Math.pow(2, i);
    }
}
```

## Validaciones Implementadas
- Verificación de campos vacíos
- Validación de triángulos válidos (suma de dos lados > tercer lado)
- Restricción de entrada binaria (solo 0 y 1)
- Validación de formato hexadecimal
- Manejo de excepciones NumberFormatException

## Capturas de Pantalla
[Las capturas se pueden agregar en una carpeta screenshots/]

## Versiones
- **v1.0.0** - Implementación inicial con todas las funcionalidades
- **v1.0.1** - Correcciones de UI y mejoras de validación
- **v1.0.2** - Optimizaciones de rendimiento

## Contacto
- **Email:** [tu_email@universidad.edu]
- **GitHub:** [tu_usuario_github]

---
**Fecha de Entrega:** [Fecha]
**Materia:** Desarrollo de Aplicaciones Móviles - NRC 74239