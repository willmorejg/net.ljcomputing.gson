/**
           Copyright 2015, James G. Willmore

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package net.ljcomputing.gson.config;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

/**
 * Configuration class implementing GSON.
 * 
 * @author James G. Willmore
 *
 */
@Configuration
@ComponentScan(basePackages = { "net.ljcomputing.gson.converter" })
public class GsonConfiguration {

  /** The SLF4J logger. */
  private static final Logger LOGGER = LoggerFactory.getLogger(GsonConfiguration.class);

  /**
   * Custom converters definitions.
   *
   * @return the http message converters
   */
  @Bean
  public HttpMessageConverters customConverters() {
    final Collection<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
    final GsonHttpMessageConverter messageConverter = new GsonHttpMessageConverter();

    messageConverters.add(messageConverter);

    LOGGER.info("Returning custom converters");

    return new HttpMessageConverters(true, messageConverters);
  }
}
