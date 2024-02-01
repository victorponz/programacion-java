# Chuletario POO

## Crear una clase

```java
public class Persona{

}
```

> -danger-El nombre de la clase **siempre** se escribe en **C**amel**C**ase

## Definir los atributos

```java
private String nombre;
private int edad;
private char sexo;
```

> -danger-Los atributos siempre son **privados**. El nombre en camel**C**ase es decir, la primera letra en minúscula

## Constructor pana inicializar los atributos

```java
public class Persona{
	private String nombre;
	private int edad;
    public Persona(String nombre, int edad, char sexo){
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }
    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = 'I';
    }
}
```

> -info-Se pueden crear tantos constructores como sea necesario e incluso no crear ninguno, en cuyo caso Java creará uno sin parámetros. Sólo hay que tener en cuenta que el tipo y orden de los parámetros no puede repetirse.

## Crear una instancia de la clase

```java
Persona p = new Persona("Pedro", 39, "M");
Persona p2 = new Persona("María", 20);
```

## Getters

Como los atributos son privados, se debe crear un método público que devuelva el estado el mismo. Por ejemplo:

```java
public String getNombre(){
	return this.nombre;
}
```

> -danger-El nombre del método **siempre** debe empezar por `get` y a continuación el nombre del atributo en **C**amel**C**ase
>
> Cuando el tipo del atributo es `boolean` el método se debe llamar `isNombreAtributo` o `hasNombreAtributo`

## Setters

Como los atributos son privados, se debe proporcionar (o no) un método para dar un valor a un atributo.

Puede ser que:

* no se cree ningún setter. Por ejemplo, supongamos que la Clase `Person` tiene un atributo DNI. Suponiendo este no puede cambiar, se inicializa en el constructor y no se proporciona ningún setter.

  ```java
  public class Persona{
  	private String nombre;
  	private int edad;
      public Persona(String nombre, int edad, char sexo, String DNI){
          this.nombre = nombre;
          this.edad = edad;
          this.sexo = sexo;
          this.DNI = DNI;
      }
  }
  ```

* se crean `n` setters. 

  ```java
  public class AirConditioned {
      private String name;
      private int temperature;
      private int maxTemp;
      private int minTemp;
  
      public AirConditioned(String name, int temperature, int maxTemp, int minTemp) {
          this.name = name;
          this.temperature = temperature;
          this.maxTemp = maxTemp;
          this.minTemp = minTemp;
      }
  
      public String geName(){
          return  this.name;
      }
  
      public int getTemperature() {
          return this.temperature;
      }
  	
      //Este setter es el típico ya que se le pasa el parámetro temperature
      public void setTemperature(int temperature) {
          if (temperature <= this.maxTemp && temperature >= this.minTemp)
              this.temperature = temperature;
      }
  	//Este setter aumenta la temperatura
      public void up(){
          if (this.temperature + 1 <= this.maxTemp)
              this.temperature++;
      }
      //Este setter baja la temperatura
      public void down(){
          if (this.temperature - 1 >= this.minTemp)
              this.temperature--;
      }
  
      @Override
      public String toString(){
          return this.name +
                  "\n\t Temperature: " + this.temperature;
      }
  }
  ```

  

> -info-**¿Por qué se usan setters en vez de hacer públicas los atributos?**
>
> Uno puede pensar en hacer los atributos públicos para que cualquiera que tenga acceso a la clase pueda dar un valor. Pero esto hace que la clase sea propensa a errores. En el ejemplo del `AireAcondicionado` se comprueba en los setters que la temperatura siempre se encuentre entre los límites. Sin embargo, si hacemos la propiedad pública, se podría fijar a valores incorrectos

Cuando se realizan chequeos en los setters para que el valor cumpla con alguna restricción, podemos hacer que el método se comporte de dos formas distintas:

1. Como hemos hecho antes. Es decir si se superan los límites no se cambia la temperatura

2. Lanzar una excepción. Por ejemplo:

   ```java
   public void setEdad(int edad){
   	if ((edad < 0 ) || (edad > 150))
           throw new IllegalArgumentException("La edad debe estar comprendida entre 0 y 150");
       this.edad = edad;
   }
   ```

   Y ahora, en el programa principal debemos capturar esta excepción:

   ```java
   Persona p = new Persona("pepe", 20, 'F', "999999999E");
   try{
       p.setEdad();
   }catch (IllegalArgumentException iae){
       System.out.println(iae.getMessage());
   }
   ```

   