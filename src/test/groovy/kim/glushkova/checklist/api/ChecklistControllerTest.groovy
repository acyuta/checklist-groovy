package kim.glushkova.checklist.api

import kim.glushkova.checklist.domain.Checklist
import kim.glushkova.checklist.service.ChecklistService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static groovy.json.JsonOutput.toJson
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 *
 */
@AutoConfigureMockMvc
@WebMvcTest
class ChecklistControllerTest extends Specification {


    @Autowired
    MockMvc mvc

    def "Create checklist with name and description"() {
        given: 'Body with name and description'
        Map request = [
                name       : 'Checklist name',
                description: 'description'
        ]

        when: 'call create checklist endpoint by POST'
        def result = mvc.perform(
                post('/api/checklist')
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(request))
        )

        then: 'response have status created'
        result.andExpect(status().isCreated())

        and: 'contains id, name and description'
        result.andExpect(jsonPath('$.id').isNumber())
        result.andExpect(jsonPath('$.name').value('Checklist name'))
        result.andExpect(jsonPath('$.description').value('description'))
    }

    def "GetAll checklists"() {
    }
}
