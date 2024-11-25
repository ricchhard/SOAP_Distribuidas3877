# SOAP_Distribuidas3877
Calculadora Java con servicios SOAP
# Calculator Web Service Project

Este proyecto integra y utiliza el servicio web SOAP **Calculator** alojado en `http://www.dneonline.com/calculator.asmx`. Este README incluye la descripción del servicio, cómo configurar el entorno, generar clientes y consumir sus operaciones.

---

## 🚀 **Descripción**

El servicio web **Calculator** expone las siguientes operaciones:
- **Add**: Suma dos números enteros.
- **Subtract**: Resta dos números enteros.
- **Multiply**: Multiplica dos números enteros.
- **Divide**: Divide dos números enteros.

Cada operación toma dos parámetros (`intA` y `intB`) y devuelve un resultado entero.

---

## 📋 **Requisitos**

- **Lenguaje de programación:** Java (u otro lenguaje compatible con SOAP).
- **Herramientas necesarias:**
  - JDK 8 o superior.
  - [Apache Maven](https://maven.apache.org/) (opcional, para manejar dependencias).
  - Cliente de SOAP, como Postman o SOAP UI (opcional para pruebas).
  - Dependencia para SOAP:
    - Si usas Java, asegúrate de incluir la biblioteca `javax.xml.ws` o usa `wsimport`.

---

## ⚙️ **Configuración del Proyecto**

### 1. **Descargar el archivo WSDL**
Descarga el archivo WSDL del servicio desde la URL:  
`http://www.dneonline.com/calculator.asmx?WSDL`.

### 2. **Generar el cliente SOAP**
En Java, usa la herramienta `wsimport` para generar las clases cliente a partir del WSDL:

```bash
`wsimport -keep -s ./src -p com.example.calculator http://www.dneonline.com/calculator.asmx?WSDL
```

- ** Opciones:
-keep: Mantiene los archivos generados.
-s ./src: Especifica el directorio donde se guardarán los archivos fuente.
-p com.example.calculator: Define el paquete en el que se generan las clases.
Esto generará las clases necesarias para consumir el servicio SOAP.

## 3. Configurar en el Proyecto
Incluye las clases generadas en tu proyecto y asegúrate de tener configuradas las dependencias necesarias.

### Manual de Uso
Paso 1: Consumir el Servicio
Ejemplo en Java para consumir la operación Add:

```java
import com.example.calculator.Calculator;
import com.example.calculator.CalculatorSoap;

public class CalculatorClient {
    public static void main(String[] args) {
        Calculator service = new Calculator();
        CalculatorSoap port = service.getCalculatorSoap();

        // Operación Add
        int result = port.add(10, 5);
        System.out.println("Resultado de la suma: " + result);

        // Operación Subtract
        int subtractResult = port.subtract(10, 5);
        System.out.println("Resultado de la resta: " + subtractResult);
    }
}
```
Paso 2: Probar el Servicio
Asegúrate de que tu proyecto está correctamente configurado.
Ejecuta el código y verifica los resultados en la consola.

### Pruebas del Servicio
Usar Postman o SOAP UI
Abre la herramienta de prueba.
Crea una nueva solicitud SOAP.
Configura la URL del servicio:
http://www.dneonline.com/calculator.asmx.
Selecciona la operación deseada y envía los parámetros en el formato XML.
