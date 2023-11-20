package BankProject.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "BankProject",
                version = "1.0.0",
                description = "Tel-Ran Bank App Project",
                contact = @Contact(
                        name = "Lev Gordin",
                        email = "lev.grdn@gmail.com",
                        url = "https://github.com/LeoGordin"
                )
        )
)
public class SwaggerConfig {
}
