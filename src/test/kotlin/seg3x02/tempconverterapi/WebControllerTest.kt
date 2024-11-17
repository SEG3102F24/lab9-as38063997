package seg3x02.tempconverterapi

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest
class WebControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun request_to_home(){
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().string("Welcome to the Temperature Converter API!"))
    }

    @Test
    fun testConvertCelsiusToFahrenheit() {
        mockMvc.perform(MockMvcRequestBuilders.get("/convertCelsiusToFahrenheit?celsius=0"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().string("32.0"))
    }

    @Test
    fun testConvertFahrenheitToCelsius() {
        mockMvc.perform(MockMvcRequestBuilders.get("/convertFahrenheitToCelsius?fahrenheit=32"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().string("0.0"))
    }
}