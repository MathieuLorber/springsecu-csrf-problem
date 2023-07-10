package com.example.demo.config

import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.beans
import org.springframework.security.web.context.HttpSessionSecurityContextRepository
import org.springframework.security.web.csrf.CookieCsrfTokenRepository
import org.springframework.security.web.csrf.XorCsrfTokenRequestAttributeHandler

class ApplicationBeans : ApplicationContextInitializer<GenericApplicationContext> {

    val beans = beans {
        bean<CookieCsrfTokenRepository>()
        bean<HttpSessionSecurityContextRepository>()
        bean<XorCsrfTokenRequestAttributeHandler>()
    }

    override fun initialize(context: GenericApplicationContext) = beans.initialize(context)
}
