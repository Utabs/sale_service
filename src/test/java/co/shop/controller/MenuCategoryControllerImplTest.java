package co.shop.controller;

import co.shop.model.mapper.MenuCategoryMapper;
import co.shop.model.mapper.ReferenceMapper;
import co.shop.service.MenuCategoryService;
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
public class MenuCategoryControllerImplTest {
    //TODO: create the data Test generator class MenuCategoryBuilder
    private static final String ENDPOINT_URL = "/menu-categorys";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private MenuCategoryControllerImpl menucategoryController;
    @MockBean
    private MenuCategoryService menucategoryService;
    @MockBean
    private MenuCategoryMapper menucategoryMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.menucategoryController).build();
    }

//    @Test
//    public void getAll() throws Exception {
//        Mockito.when(menucategoryMapper.asDTOList(ArgumentMatchers.any())).thenReturn(MenuCategoryBuilder.getListDTO());
//
//        Mockito.when(menucategoryService.findAll()).thenReturn(MenuCategoryBuilder.getListEntities());
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
//        Mockito.when(menucategoryMapper.asDTO(ArgumentMatchers.any())).thenReturn(MenuCategoryBuilder.getDTO());
//
//        Mockito.when(menucategoryService.findById(ArgumentMatchers.anyInteger())).thenReturn(java.util.Optional.of(MenuCategoryBuilder.getEntity()));
//
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
//        Mockito.verify(menucategoryService, Mockito.times(1)).findById(1L);
//        Mockito.verifyNoMoreInteractions(menucategoryService);
//    }
//
//    @Test
//    public void save() throws Exception {
//        Mockito.when(menucategoryMapper.asEntity(ArgumentMatchers.any())).thenReturn(MenuCategoryBuilder.getEntity());
//        Mockito.when(menucategoryService.save(ArgumentMatchers.any(MenuCategory.class))).thenReturn(MenuCategoryBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.post(ENDPOINT_URL)
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(MenuCategoryBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//        Mockito.verify(menucategoryService, Mockito.times(1)).save(ArgumentMatchers.any(MenuCategory.class));
//        Mockito.verifyNoMoreInteractions(menucategoryService);
//    }
//
//    @Test
//    public void update() throws Exception {
//        Mockito.when(menucategoryMapper.asEntity(ArgumentMatchers.any())).thenReturn(MenuCategoryBuilder.getEntity());
//        Mockito.when(menucategoryService.update(ArgumentMatchers.any(), ArgumentMatchers.anyInteger())).thenReturn(MenuCategoryBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(MenuCategoryBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(menucategoryService, Mockito.times(1)).update(ArgumentMatchers.any(MenuCategory.class), ArgumentMatchers.anyInteger());
//        Mockito.verifyNoMoreInteractions(menucategoryService);
//    }
//
//    @Test
//    public void delete() throws Exception {
//        Mockito.doNothing().when(menucategoryService).deleteById(ArgumentMatchers.anyInteger());
//        mockMvc.perform(
//                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(menucategoryService, Mockito.times(1)).deleteById(Mockito.anyInteger());
//        Mockito.verifyNoMoreInteractions(menucategoryService);
//    }
}
