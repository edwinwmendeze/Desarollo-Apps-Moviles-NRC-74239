# Desarrollo de Aplicaciones Móviles - NRC 74239

Repositorio de los ejercicios que vamos haciendo en clase. Aquí subo las apps que el profesor nos deja de tarea y lo que hacemos durante las clases.

Todo está hecho en Android Studio usando Java.

---

## Estructura

``` md
Unidad1/
├── Ejercicio1/   # App que suma dos números
├── Ejercicio2/   # Calculadora básica
├── Ejercicio3/   # Calculadora para veterinarios
├── Ejercicio4/   # Sistema de ventas
└── PA1/          # Producto Academico 1 - App con Navigation Drawer
    └── mendez_pa1/
```

Las otras unidades las voy subiendo conforme avance el semestre.

---

## Ejercicios de la Unidad 1

### Ejercicio 1: App que suma números (Terminado)

Es una app sencilla donde colocas dos números y te da la suma. También valida que no dejes campos vacíos.

**Archivos principales:**
- [MainActivity.java](Unidad1/Ejercicio1/app/src/main/java/com/ewme/sumatoriadenumeros/MainActivity.java)
- [activity_main.xml](Unidad1/Ejercicio1/app/src/main/res/layout/activity_main.xml)

**Pruebas:**
- 11 + 35 = 46
- -5 + 2.5 = -2.5
- Si no pones números te sale un mensaje

---

### Ejercicio 2: Calculadora básica (Terminado)

Calculadora que hace las operaciones básicas: suma, resta, multiplicación, división y módulo. Controla cuando divides entre cero para que no se rompa la app.

**Archivos principales:**
- [MainActivity.java](Unidad1/Ejercicio2/app/src/main/java/com/ewme/calculadorabasicaops/MainActivity.java)
- [activity_main.xml](Unidad1/Ejercicio2/app/src/main/res/layout/activity_main.xml)

**Pruebas:**
- 12 + 5 = 17
- 12 - 5 = 7  
- 12 × 5 = 60
- 12 ÷ 5 = 2.4
- 12 % 5 = 2
- 10 ÷ 0 → Te sale mensaje de error

---

### Ejercicio 3: Calculadora para veterinarios (Terminado)

App para calcular dosis de medicamentos para perros y gatos según su peso. Calcula dosis por toma, dosis diaria, número de tabletas o volumen en ml, y mantenimiento hídrico estimado.

**Archivos principales:**
- [MainActivity.java](Unidad1/Ejercicio3/app/src/main/java/com/ewme/calcdosisvet/MainActivity.java)
- [activity_main.xml](Unidad1/Ejercicio3/app/src/main/res/layout/activity_main.xml)

**Pruebas:**
- Perro 10kg, dosis 5mg/kg, 2 tomas/día, presentación 50mg/tableta:
  - Dosis por toma: 50 mg
  - Dosis diaria: 100 mg  
  - Tabletas por toma: 1.0 tab
  - Mantenimiento hídrico: 600 ml/día
- Gato 4kg, dosis 2mg/kg, 3 tomas/día, concentración 20mg/ml:
  - Dosis por toma: 8 mg
  - Dosis diaria: 24 mg
  - Volumen por toma: 0.4 ml
  - Mantenimiento hídrico: 240 ml/día

---

### Ejercicio 4: Sistema de ventas (Terminado)

App para calcular el total de una venta en una tienda de equipos informáticos. Incluye subtotal, descuentos opcionales e IGV (18%) aplicado después del descuento.

**Archivos principales:**
- [MainActivity.java](Unidad1/Ejercicio4/app/src/main/java/com/ewme/tiendainfo/MainActivity.java)
- [activity_main.xml](Unidad1/Ejercicio4/app/src/main/res/layout/activity_main.xml)

**Pruebas:**
- Laptop HP, precio S/ 2500, cantidad 2, descuento 10%:
  - Subtotal: S/ 5000.00
  - Descuento (10%): S/ 500.00
  - Subtotal con descuento: S/ 4500.00
  - IGV (18%): S/ 810.00
  - TOTAL A PAGAR: S/ 5310.00
- Sin descuento se calcula IGV sobre el subtotal completo
- Valida que precio y cantidad sean > 0 y descuento entre 0-100%

---

### PA1: Producto Academico 1 - Navigation Drawer (✅ COMPLETADO)

App completa con Navigation Drawer que incluye 5 funciones matemáticas diferentes y splash screen animado. Proyecto diseñado para demostrar el uso de fragments, navegación, cálculos matemáticos y conversiones numéricas.

**Estado actual:** ✅ TODAS LAS FUNCIONALIDADES IMPLEMENTADAS Y PROBADAS

**Archivos principales:**

**🎬 Splash & Navigation:**
- [Splash.java](Unidad1/PA1/mendez_pa1/app/src/main/java/mendez/pa1/org/Splash.java) - Pantalla de inicio animada (3 segundos)
- [MainActivity.java](Unidad1/PA1/mendez_pa1/app/src/main/java/mendez/pa1/org/MainActivity.java) - Navigation Drawer principal
- [activity_splash.xml](Unidad1/PA1/mendez_pa1/app/src/main/res/layout/activity_splash.xml) - Layout del splash
- [app_bar_main.xml](Unidad1/PA1/mendez_pa1/app/src/main/res/layout/app_bar_main.xml) - AppBar sin FAB ni menú settings

**🎨 Estilos y Recursos:**
- [styles.xml](Unidad1/PA1/mendez_pa1/app/src/main/res/values/styles.xml) - Sistema completo de estilos uniformes
- [colors.xml](Unidad1/PA1/mendez_pa1/app/src/main/res/values/colors.xml) - Paleta de colores personalizada basada en logo
- [themes.xml](Unidad1/PA1/mendez_pa1/app/src/main/res/values/themes.xml) - Tema personalizado integrado
- [gradiente.xml](Unidad1/PA1/mendez_pa1/app/src/main/res/drawable/gradiente.xml) - Fondo degradado del splash
- [animation.xml](Unidad1/PA1/mendez_pa1/app/src/main/res/anim/animation.xml) - Animación fade-in

**🧮 Fragment 1: Área del Triángulo (Fórmula de Herón)**
- [AreaTrianguloFragment.java](Unidad1/PA1/mendez_pa1/app/src/main/java/mendez/pa1/org/ui/areatriangulo/AreaTrianguloFragment.java)
- [fragment_area_triangulo.xml](Unidad1/PA1/mendez_pa1/app/src/main/res/layout/fragment_area_triangulo.xml)
- **Funcionalidad:** Calcula área usando la fórmula de Herón con validaciones de triángulo válido
- **Validaciones:** Campos vacíos, desigualdad triangular, formato de resultado con 2 decimales

**🎲 Fragment 2: Número Aleatorio con Validación**
- [NumeroAleatorioFragment.java](Unidad1/PA1/mendez_pa1/app/src/main/java/mendez/pa1/org/ui/numeroaleatorio/NumeroAleatorioFragment.java)
- [fragment_numero_aleatorio.xml](Unidad1/PA1/mendez_pa1/app/src/main/res/layout/fragment_numero_aleatorio.xml)
- **Funcionalidad:** Genera número aleatorio de 6 dígitos y determina si tiene exactamente 3 dígitos impares
- **Validaciones:** Muestra "Es correcto" o "No es adecuado" con conteo de impares

**🔢 Fragment 3: Conversión Binario → Decimal**
- [BinarioDecimalFragment.java](Unidad1/PA1/mendez_pa1/app/src/main/java/mendez/pa1/org/ui/binariodecimal/BinarioDecimalFragment.java)
- [fragment_binario_decimal.xml](Unidad1/PA1/mendez_pa1/app/src/main/res/layout/fragment_binario_decimal.xml)
- **Funcionalidad:** Convierte números binarios a decimales usando algoritmo de potencias de 2
- **Validaciones:** Solo acepta 0s y 1s (validado en layout con `android:digits="01"`)

**🔤 Fragment 4: Conversión Hexadecimal → Binario**
- [HexBinarioFragment.java](Unidad1/PA1/mendez_pa1/app/src/main/java/mendez/pa1/org/ui/hexbinario/HexBinarioFragment.java)
- [fragment_hex_binario.xml](Unidad1/PA1/mendez_pa1/app/src/main/res/layout/fragment_hex_binario.xml)
- **Funcionalidad:** Convierte hexadecimales a binarios (cada dígito hex = 4 bits binarios)
- **Validaciones:** Solo acepta caracteres hexadecimales válidos (0-9, A-F)

**👤 Fragment 5: Acerca de**
- [AcercaFragment.java](Unidad1/PA1/mendez_pa1/app/src/main/java/mendez/pa1/org/ui/acerca/AcercaFragment.java)
- [fragment_acerca.xml](Unidad1/PA1/mendez_pa1/app/src/main/res/layout/fragment_acerca.xml)
- **Funcionalidad:** Información personal del desarrollador

**🛠️ Configuración:**
- [AndroidManifest.xml](Unidad1/PA1/mendez_pa1/app/src/main/AndroidManifest.xml) - Splash como launcher, permisos
- [activity_main_drawer.xml](Unidad1/PA1/mendez_pa1/app/src/main/res/menu/activity_main_drawer.xml) - Menú de navegación
- [mobile_navigation.xml](Unidad1/PA1/mendez_pa1/app/src/main/res/navigation/mobile_navigation.xml) - Navigation graph
- [main.xml](Unidad1/PA1/mendez_pa1/app/src/main/res/menu/main.xml) - Menú settings deshabilitado

**✅ Funcionalidades completadas:**
- ✅ Splash Activity con animación fade-in (3 segundos)
- ✅ Navigation Drawer completamente funcional
- ✅ Sistema de estilos uniforme y paleta de colores personalizada
- ✅ **Área del Triángulo:** Fórmula de Herón con validaciones completas
- ✅ **Número Aleatorio:** Generación y validación de 3 dígitos impares
- ✅ **Binario → Decimal:** Conversión con algoritmo de potencias de 2
- ✅ **Hexadecimal → Binario:** Conversión dígito por dígito (switch statement)
- ✅ **Fragment Acerca:** Información del desarrollador
- ✅ FAB y menú settings deshabilitados (comentados)
- ✅ Validaciones de entrada en todos los fragments
- ✅ Manejo de errores y mensajes Toast informativos
- ✅ Layouts responsivos con ScrollView

**🧪 Casos de prueba validados:**

**Área del Triángulo:**
- Triángulos válidos: (3,4,5)→6.00 cm², (5,5,5)→10.83 cm²
- Triángulos inválidos: (1,2,5) muestra error de desigualdad triangular
- Campos vacíos: muestra Toast de validación

**Número Aleatorio:**
- Genera números de exactamente 6 dígitos (100000-999999)
- Identifica correctamente si tiene 3 dígitos impares
- Muestra conteo detallado cuando no cumple condición

**Binario → Decimal:**
- "1011" → 11, "1111" → 15, "10101" → 21
- Solo acepta 0s y 1s en tiempo real

**Hexadecimal → Binario:**
- "1A2F" → "0001101000101111"
- "FF" → "11111111"
- Maneja mayúsculas y minúsculas automáticamente

---

## Cómo ejecutar las apps

1. Abrir Android Studio
2. File → Open → Elegir la carpeta del ejercicio (ej: `Unidad1/Ejercicio1/`)
3. Darle al botón Run ▶
4. Probar en el emulador o tu celular

---

*Curso: Desarrollo de Aplicaciones Móviles - NRC 74239*