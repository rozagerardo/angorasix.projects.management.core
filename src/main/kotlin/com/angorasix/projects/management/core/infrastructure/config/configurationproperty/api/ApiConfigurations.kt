package com.angorasix.projects.management.core.infrastructure.config.configurationproperty.api

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod

/**
 * <p>
 *  Base file containing all Service configurations.
 * </p>
 *
 * @author rozagerardo
 */
@Configuration
@ConfigurationProperties(prefix = "configs.api")
class ApiConfigs {
    lateinit var headers: HeadersConfigs
    lateinit var routes: RoutesConfigs
    lateinit var basePaths: BasePathConfigs
}

class HeadersConfigs @ConstructorBinding constructor(val contributor: String)

class BasePathConfigs @ConstructorBinding constructor(val projectsManagement: String)

class RoutesConfigs @ConstructorBinding constructor(
    val baseListCrudRoute: String,
    val baseByIdCrudRoute: String,
    val createProjectManagement: Route,
    val updateProjectManagement: Route,
    val getProjectManagement: Route,
    val listProjectManagements: Route,
)

data class Route(
    val name: String,
    val basePaths: List<String>,
    val method: HttpMethod,
    val path: String,
) {
    fun resolvePath(): String = basePaths.joinToString("").plus(path)
}