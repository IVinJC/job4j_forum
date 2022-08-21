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
import ru.job4j.model.Post;
import ru.job4j.service.PostService;

import java.util.Calendar;
import java.util.GregorianCalendar;

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
public class PostControllerTest {

    @MockBean
    private PostService postService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Ignore
    @WithMockUser
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(post("/create")
                        .param("name", "Куплю ладу-грант. Дорого.")
                        .param("description", """
                Продаю машину ВАЗ 2109 1987 года серого цвета, не битая, не крашенная))))
                """)
                        .param("created", new GregorianCalendar(2022, Calendar.AUGUST, 19).toString()))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(postService).create(argument.capture());
        assertThat(argument.getValue().getName(), is("Куплю ладу-грант. Дорого."));
    }

    @Test
    @Ignore
    @WithMockUser
    public void shouldReturnPost() throws Exception {
        this.mockMvc.perform(get("/post/{id}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post"));
    }

    @Test
    @Ignore
    @WithMockUser
    public void shouldReturnLogin() throws Exception {
        this.mockMvc.perform(get("/edit/{id}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("edit"));
    }

    @Test
    @Ignore
    @WithMockUser
    public void shouldReturnPostName() throws Exception {
        this.mockMvc.perform(post("/post/{id}")
                        .param("id", "1")
                        .param("name", "Куплю ладу-грант. Дорого.")
                        .param("description", """
                Продаю машину ВАЗ 2109 1987 года серого цвета, не битая, не крашенная))))
                """)
                        .param("created", new GregorianCalendar(2022, Calendar.AUGUST, 19).toString()))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(postService).create(argument.capture());
        assertThat(argument.getValue().getName(), is("Куплю ладу-грант. Дорого."));
    }
}