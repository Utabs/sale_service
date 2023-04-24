package co.shop.controller;

import co.shop.controller.impl.UsersControllerImpl;
import co.shop.model.mapper.ReferenceMapper;
import co.shop.model.mapper.UsersMapper;
import co.shop.service.UsersService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class UsersControllerImplTest {
    //TODO: create the data Test generator class UsersBuilder
    private static final String ENDPOINT_URL = "/userss";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private UsersControllerImpl usersController;
    @MockBean
    private UsersService usersService;
    @MockBean
    private UsersMapper usersMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.usersController).build();
    }
//
//    @Test
//    public void getAll() throws Exception {
//        Mockito.when(usersMapper.asDTOList(ArgumentMatchers.any())).thenReturn(UsersBuilder.getListDTO());
//
//        Mockito.when(usersService.findAll()).thenReturn(UsersBuilder.getListEntities());
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
//
//    }
//
//    @Test
//    public void getById() throws Exception {
//        Mockito.when(usersMapper.asDTO(ArgumentMatchers.any())).thenReturn(UsersBuilder.getDTO());
//
//        Mockito.when(usersService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(UsersBuilder.getEntity()));
//
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
//        Mockito.verify(usersService, Mockito.times(1)).findById(1L);
//        Mockito.verifyNoMoreInteractions(usersService);
//    }
//
//    @Test
//    public void save() throws Exception {
//        Mockito.when(usersMapper.asEntity(ArgumentMatchers.any())).thenReturn(UsersBuilder.getEntity());
//        Mockito.when(usersService.save(ArgumentMatchers.any(Users.class))).thenReturn(UsersBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.post(ENDPOINT_URL)
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(UsersBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//        Mockito.verify(usersService, Mockito.times(1)).save(ArgumentMatchers.any(Users.class));
//        Mockito.verifyNoMoreInteractions(usersService);
//    }
//
//    @Test
//    public void update() throws Exception {
//        Mockito.when(usersMapper.asEntity(ArgumentMatchers.any())).thenReturn(UsersBuilder.getEntity());
//        Mockito.when(usersService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(UsersBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(UsersBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(usersService, Mockito.times(1)).update(ArgumentMatchers.any(Users.class), ArgumentMatchers.anyLong());
//        Mockito.verifyNoMoreInteractions(usersService);
//    }
//
//    @Test
//    public void delete() throws Exception {
//        Mockito.doNothing().when(usersService).deleteById(ArgumentMatchers.anyLong());
//        mockMvc.perform(
//                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(usersService, Mockito.times(1)).deleteById(Mockito.anyLong());
//        Mockito.verifyNoMoreInteractions(usersService);
}
