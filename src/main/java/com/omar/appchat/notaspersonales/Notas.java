/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.omar.appchat.notaspersonales;

/**
 *
 * @author omara
 */
public class Notas {
    /*
    PRINCIPALES ANOTACIONES EN SPRING BOOT
    Las anotaciones en Spring Boot son etiquetas que se pueden utilizar en el código para configurar y definir el comportamiento de mi aplicación.
    Estas anotaciones eliminan la necesidad de configuraciones manuales extensas, permiten que SB detecte automaticamente las clases, métodos
    o propiedades específicas  y las administre según el rol de la aplicacíón. Facilitan la inyección de dependencias, la configuración del 
    contexto y el manejo de la lógica especifica en mi proyecto.
    
    
    En el método main
    @SpringBootAplication --> Habilita la autoconfiguración de Spring Boot  y el escaneo de componentes
    
    @Component --> Se utiliza para marcar una clase como un componente generico gestionado spring como un bean (un bean es un objeto gestionado por 
                   el contenedor de spring, es generica y se usa para clases que no encajan en categorías específicas como servicios o repositorios.
    
                   Si en este proyecto desarrollo una clase auxiliar como un validador de datos o alguna utilidad para formatear mensajes, puedo 
                   anotarlas con la etiqueta @component para que spring las registre y pueda iyectarlas.
    
    @Controller --> Marca la clase como un controlador web, capaz de manejar las solicitudes HTTP. Normalmente se utiliza en aplicaciones web que
                    devuelven vistas (html o jsp)
    
    @RestController --> Similar a @Controller, esta anotación se utiliza para marcar una clase como un controlador, 
                        pero se utiliza específicamente para crear servicios web RESTful, es como una combinación de @Controller y @ResponseBody lo
                        que significa que esta clase manejara solicitudes http pero devolverá datos directamente en el cuerpo de la respuesta como
                        xml o json.
    
    @RequestMapping --> Mapea una solcitud HTTP con una ruta a un método del controlador --> Se puede utilizar a nível de método pero también de clase.
                        Se pueden especificar métodos especificos como GET, POST, PUT, entre otros. Organiza mejor las rutas de los controladores, 
                        por ejemplo, agrupando todas las rutas relacionadas con usuarios bajo /users
    
    @Bean --> Indica que un método produce un Bean para ser gestionado por Spring. Si se necesita registrar un objeto como un servicio de terceros o una
              clase específica para la configuración del proyecto.
    
    @Service --> Indica que una clase anotada es una clase de servicio. Es una especialización de @Component, utilizada para definir la logica del negocio.
                 En mi proyecto la puedo usar para la lógica de mensajería como enviar notificaciones o cifrar mensajes.
    
    @Repository --> Indica que una clase anotada es un repositorio, que es una abstracción de acceso y un almacenamiento de datos.
                    Se utiliza interactuar con la base de datos
    
    @Autowired --> Marca un constructor o método setter para ser inyectado automáticamente por la inyección de dependencias de Spring.
                    
    @Configuration --> Indica que una clase es una clase de configuración que puede contener definiciones Beans. Permite centralizar configuraciones 
                       específicas, como registrar servicios, utilidades o beans personalizados.
    
    */
}
