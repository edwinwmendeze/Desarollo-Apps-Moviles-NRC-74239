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
└── Ejercicio4/   # Sistema de ventas
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

## Cómo ejecutar las apps

1. Abrir Android Studio
2. File → Open → Elegir la carpeta del ejercicio (ej: `Unidad1/Ejercicio1/`)
3. Darle al botón Run ▶
4. Probar en el emulador o tu celular

---

*Curso: Desarrollo de Aplicaciones Móviles - NRC 74239*