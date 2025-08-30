# PA1 - Producto Académico 1: Navigation Drawer

## Información del Estudiante
- **Estudiante:** Edwin Wladimir Mendez
- **Curso:** Desarrollo de Aplicaciones Móviles
- **NRC:** 74239

## Descripción General
App completa con Navigation Drawer que incluye 5 funciones matemáticas diferentes y splash screen animado. Proyecto diseñado para demostrar el uso de fragments, navegación, cálculos matemáticos y conversiones numéricas.

**Estado actual:** TODAS LAS FUNCIONALIDADES IMPLEMENTADAS Y PROBADAS

## Funcionalidades Implementadas

### 1. Área del Triángulo (Fórmula de Herón)
- **Archivo:** [AreaTrianguloFragment.java](mendez_pa1/app/src/main/java/mendez/pa1/org/ui/areatriangulo/AreaTrianguloFragment.java)
- **Layout:** [fragment_area_triangulo.xml](mendez_pa1/app/src/main/res/layout/fragment_area_triangulo.xml)
- Calcula área usando la fórmula de Herón con validaciones de triángulo válido
- **Validaciones:** Campos vacíos, desigualdad triangular, formato con 2 decimales
- **Casos de prueba:** (3,4,5) → 6.00 cm², (5,5,5) → 10.83 cm²

### 2. Generador de Número Aleatorio con Validación
- **Archivo:** [NumeroAleatorioFragment.java](mendez_pa1/app/src/main/java/mendez/pa1/org/ui/numeroaleatorio/NumeroAleatorioFragment.java)
- **Layout:** [fragment_numero_aleatorio.xml](mendez_pa1/app/src/main/res/layout/fragment_numero_aleatorio.xml)
- Genera números de exactamente 6 dígitos (100000-999999)
- Determina si tiene exactamente 3 dígitos impares
- Muestra "Es correcto" o "No es adecuado" con conteo de impares

### 3. Conversión Binario a Decimal
- **Archivo:** [BinarioDecimalFragment.java](mendez_pa1/app/src/main/java/mendez/pa1/org/ui/binariodecimal/BinarioDecimalFragment.java)
- **Layout:** [fragment_binario_decimal.xml](mendez_pa1/app/src/main/res/layout/fragment_binario_decimal.xml)
- Convierte números binarios a decimales usando algoritmo de potencias de 2
- **Validación:** Solo acepta 0s y 1s (validado con `android:digits="01"`)
- **Casos de prueba:** "1011" → 11, "1111" → 15, "10101" → 21

### 4. Conversión Hexadecimal a Binario
- **Archivo:** [HexBinarioFragment.java](mendez_pa1/app/src/main/java/mendez/pa1/org/ui/hexbinario/HexBinarioFragment.java)
- **Layout:** [fragment_hex_binario.xml](mendez_pa1/app/src/main/res/layout/fragment_hex_binario.xml)
- Convierte hexadecimales a binarios (cada dígito hex = 4 bits binarios)
- **Casos de prueba:** "1A2F" → "0001101000101111", "FF" → "11111111"

### 5. Acerca de
- **Archivo:** [AcercaFragment.java](mendez_pa1/app/src/main/java/mendez/pa1/org/ui/acerca/AcercaFragment.java)
- **Layout:** [fragment_acerca.xml](mendez_pa1/app/src/main/res/layout/fragment_acerca.xml)
- Información personal del desarrollador

## Arquitectura y Componentes Principales

### Splash Screen y Navigation
- **[Splash.java](mendez_pa1/app/src/main/java/mendez/pa1/org/Splash.java)** - Pantalla de inicio animada (3 segundos)
- **[MainActivity.java](mendez_pa1/app/src/main/java/mendez/pa1/org/MainActivity.java)** - Navigation Drawer principal
- **[activity_splash.xml](mendez_pa1/app/src/main/res/layout/activity_splash.xml)** - Layout del splash con animación fade-in
- **[app_bar_main.xml](mendez_pa1/app/src/main/res/layout/app_bar_main.xml)** - AppBar sin FAB ni menú settings

### Estilos y Recursos Personalizados
- **[styles.xml](mendez_pa1/app/src/main/res/values/styles.xml)** - Sistema completo de estilos uniformes
- **[colors.xml](mendez_pa1/app/src/main/res/values/colors.xml)** - Paleta de colores personalizada
- **[themes.xml](mendez_pa1/app/src/main/res/values/themes.xml)** - Tema personalizado integrado
- **[gradiente.xml](mendez_pa1/app/src/main/res/drawable/gradiente.xml)** - Fondo degradado del splash
- **[animation.xml](mendez_pa1/app/src/main/res/anim/animation.xml)** - Animación fade-in

### Configuración del Proyecto
- **[AndroidManifest.xml](mendez_pa1/app/src/main/AndroidManifest.xml)** - Splash como launcher, permisos
- **[activity_main_drawer.xml](mendez_pa1/app/src/main/res/menu/activity_main_drawer.xml)** - Menú de navegación con 5 opciones
- **[mobile_navigation.xml](mendez_pa1/app/src/main/res/navigation/mobile_navigation.xml)** - Navigation graph completo
- **[main.xml](mendez_pa1/app/src/main/res/menu/main.xml)** - Menú settings deshabilitado

## Instalación y Ejecución

### Requisitos Previos
- Android Studio Arctic Fox o superior
- Android SDK 24 (API Level 24) o superior
- JDK 8 o superior

### Pasos de Instalación
1. Clonar este repositorio:
   ```bash
   git clone https://github.com/edwinwmendeze/NRC-74239.git
   ```

2. Abrir el proyecto en Android Studio:
   - File → Open → Seleccionar carpeta `mendez_pa1`

3. Sincronizar el proyecto:
   - Click en "Sync Now" cuando aparezca la notificación

4. Ejecutar la aplicación:
   - Conectar dispositivo Android o iniciar emulador
   - Click en Run (botón verde) o Shift+F10
   - La app iniciará con el splash screen animado

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

## Algoritmos Implementados

### 1. Fórmula de Herón para Área de Triángulo
```java
// Validación de desigualdad triangular
if (lado1 + lado2 <= lado3 || lado1 + lado3 <= lado2 || lado2 + lado3 <= lado1) {
    Toast.makeText(getContext(), "Los lados no forman un triángulo válido", Toast.LENGTH_SHORT).show();
    return;
}

// Cálculo del área
double semiperimetro = (lado1 + lado2 + lado3) / 2;
double area = Math.sqrt(semiperimetro * (semiperimetro - lado1) * 
                       (semiperimetro - lado2) * (semiperimetro - lado3));
```

### 2. Conversión Binario a Decimal
```java
int decimal = 0;
for (int i = 0; i < binario.length(); i++) {
    char bit = binario.charAt(binario.length() - 1 - i);
    if (bit == '1') {
        decimal += Math.pow(2, i);
    }
}
```

### 3. Conversión Hexadecimal a Binario
```java
// Conversión dígito por dígito usando switch
switch (hexChar) {
    case '0': return "0000";
    case '1': return "0001";
    case '2': return "0010";
    // ... continúa hasta F
    case 'F': case 'f': return "1111";
}
```

## Casos de Prueba Validados

### Área del Triángulo
- **Triángulos válidos:** (3,4,5) → 6.00 cm², (5,5,5) → 10.83 cm²
- **Triángulos inválidos:** (1,2,5) muestra error de desigualdad triangular
- **Campos vacíos:** Muestra Toast de validación

### Número Aleatorio
- Genera números de exactamente 6 dígitos (100000-999999)
- Identifica correctamente si tiene 3 dígitos impares
- Muestra conteo detallado cuando no cumple condición

### Binario a Decimal
- **"1011"** → 11
- **"1111"** → 15  
- **"10101"** → 21
- Solo acepta 0s y 1s en tiempo real

### Hexadecimal a Binario
- **"1A2F"** → "0001101000101111"
- **"FF"** → "11111111"
- Maneja mayúsculas y minúsculas automáticamente

---

**Curso:** Desarrollo de Aplicaciones Móviles - NRC 74239  
**Estado:** PROYECTO COMPLETADO ✓