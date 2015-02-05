package controllers

import play.api._
import play.api.mvc._

import play.api.i18n.Messages

import play.api.Play.current 

object Application extends Controller {

  // This will always use the default language of the application - user settings ignored!
  def alwaysDefault = Action {
    Ok(Messages("hello"))
  }

  // This will always apply localization as requested by the client agent.
  def alwaysDefaultWithRequest = Action { request =>
    Ok(Messages("hello"))
  }

  // This will ignore the language supplied to withLang! Compare with next one,
  // which uses the user-chosen language. The difference is that the request parameter here is not implicit. 
  def explicitLanguageIgnored = Action { request => 
    Ok(Messages("hello")).withLang(request.acceptLanguages.head)
  }

  // This will apply the first localization present in the client's Accept-language header component. 
  def explicitLanguageV1 = Action { implicit request => 
    Ok(Messages("hello")).withLang(request.acceptLanguages.head)
  }

  // This will apply the first localization present in the client's Accept-language header component. 
  def explicitLanguageV2 = Action { implicit request => 
    Ok(Messages("hello")(request.acceptLanguages.head))
  }

  // This will apply the first localization present in the client's Accept-language header component. 
  def explicitLanguageV3 = Action { request => 
    Ok(Messages("hello")(request.acceptLanguages.head))
  }

  // This will always apply localization as requested by the client agent. 
  def index = Action { implicit request =>
    Ok(Messages("hello"))
  }
  
}
