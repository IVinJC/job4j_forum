package ru.job4j.controllers;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.Main;
import ru.job4j.model.Authority;
import ru.job4j.model.User;
import ru.job4j.service.UserService;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class RegControllerTest {
    @MockBean
    private UserService userService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Ignore
    @WithMockUser
    public void shouldReturnLoginPage() throws Exception {
        this.mockMvc.perform(get("/loginPage"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("loginPage"));
    }

    @Test
    @Ignore
    @WithMockUser
    public void shouldReturnReg() throws Exception {
        this.mockMvc.perform(get("/reg"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("reg"));
    }

    @Test
    @Ignore
    @WithMockUser
    public void shouldReturnPostName() throws Exception {
        this.mockMvc.perform(post("/reg")
                        .param("id", "1")
                        .param("password", "user1")
                        .param("username", "user1")
                        .param("authority", new Authority(1, "user").toString()))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        verify(userService).add(argument.capture());
        assertThat(argument.getValue().getUsername(), is("user1"));
    }
}