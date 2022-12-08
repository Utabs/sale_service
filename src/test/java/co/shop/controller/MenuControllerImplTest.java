package co.shop.controller;

import co.shop.model.mapper.MenuMapper;
import co.shop.model.mapper.ReferenceMapper;
import co.shop.service.MenuService;
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
public class MenuControllerImplTest {
    //TODO: create the data Test generator class MenuBuilder
    private static final String ENDPOINT_URL = "/menus";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private MenuControllerImpl menuController;
    @MockBean
    private MenuService menuService;
    @MockBean
    private MenuMapper menuMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.menuController).build();
    }

//    @Test
//    public void getAll() throws Exception {
//        Mockito.when(menuMapper.asDTOList(ArgumentMatchers.any())).thenReturn(MenuBuilder.getListDTO());
//
//        Mockito.when(menuService.findAll()).thenReturn(MenuBuilder.getListEntities());
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
//        Mockito.when(menuMapper.asDTO(ArgumentMatchers.any())).thenReturn(MenuBuilder.getDTO());
//
//        Mockito.when(menuService.findById(ArgumentMatchers.anyInteger())).thenReturn(java.util.Optional.of(MenuBuilder.getEntity()));
//
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
//        Mockito.verify(menuService, Mockito.times(1)).findById(1L);
//        Mockito.verifyNoMoreInteractions(menuService);
//    }
//
//    @Test
//    public void save() throws Exception {
//        Mockito.when(menuMapper.asEntity(ArgumentMatchers.any())).thenReturn(MenuBuilder.getEntity());
//        Mockito.when(menuService.save(ArgumentMatchers.any(Menu.class))).thenReturn(MenuBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.post(ENDPOINT_URL)
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(MenuBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//        Mockito.verify(menuService, Mockito.times(1)).save(ArgumentMatchers.any(Menu.class));
//        Mockito.verifyNoMoreInteractions(menuService);
//    }
//
//    @Test
//    public void update() throws Exception {
//        Mockito.when(menuMapper.asEntity(ArgumentMatchers.any())).thenReturn(MenuBuilder.getEntity());
//        Mockito.when(menuService.update(ArgumentMatchers.any(), ArgumentMatchers.anyInteger())).thenReturn(MenuBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(MenuBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(menuService, Mockito.times(1)).update(ArgumentMatchers.any(Menu.class), ArgumentMatchers.anyInteger());
//        Mockito.verifyNoMoreInteractions(menuService);
//    }
//
//    @Test
//    public void delete() throws Exception {
//        Mockito.doNothing().when(menuService).deleteById(ArgumentMatchers.anyInteger());
//        mockMvc.perform(
//                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(menuService, Mockito.times(1)).deleteById(Mockito.anyInteger());
//        Mockito.verifyNoMoreInteractions(menuService);
//    }
}
