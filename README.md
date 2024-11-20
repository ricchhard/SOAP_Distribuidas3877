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
wsimport -keep -s ./src -p com.example.calculator http://www.dneonline.com/calculator.asmx?WSDL
