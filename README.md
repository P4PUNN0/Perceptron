# Perceptron

Aplicación de consola en Java que implementa un perceptrón sencillo para calcular una salida binaria a partir de dos entradas.

## Funcionalidad

- Inicializa los pesos aleatoriamente usando una semilla configurable.
- Calcula la suma ponderada de las entradas y el sesgo.
- Aplica una función de activación escalón: devuelve `1` si la suma es mayor o igual que cero y `0` en caso contrario.
- Incluye métodos para consultar y actualizar pesos y sesgo, y para guardar o cargar esos valores desde un archivo.
- El método `main` ejecuta ejemplos con las entradas `[0, 0]`, `[0, 1]`, `[1, 0]` y `[1, 1]`.

El programa de ejemplo no entrena el perceptrón; muestra predicciones con los pesos aleatorios inicializados al arrancar.

## Requisitos

- JDK 23, según la configuración del proyecto.

## Compilar y ejecutar

Desde la carpeta del proyecto, compila y ejecuta con:

```text
javac -d out src/perceptron/Perceptron.java
java -cp out perceptron.Perceptron
```

También puedes abrir la carpeta del proyecto en Apache NetBeans y ejecutar `perceptron.Perceptron`.

## Estructura

- `src/perceptron/Perceptron.java`: implementación, persistencia de pesos y programa de demostración.
