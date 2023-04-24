package co.shop.controller;

import co.shop.controller.impl.RoleControllerImpl;
import co.shop.model.mapper.ReferenceMapper;
import co.shop.model.mapper.RoleMapper;
import co.shop.service.RoleService;
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
public class RoleControllerImplTest {
    //TODO: create the data Test generator class RoleBuilder
    private static final String ENDPOINT_URL = "/roles";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private RoleControllerImpl roleController;
    @MockBean
    private RoleService roleService;
    @MockBean
    private RoleMapper roleMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.roleController).build();
    }
//
//    @Test
//    public void getAll() throws Exception {
//        Mockito.when(roleMapper.asDTOList(ArgumentMatchers.any())).thenReturn(RoleBuilder.getListDTO());
//
//        Mockito.when(roleService.findAll()).thenReturn(RoleBuilder.getListEntities());
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
//        Mockito.when(roleMapper.asDTO(ArgumentMatchers.any())).thenReturn(RoleBuilder.getDTO());
//
//        Mockito.when(roleService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(RoleBuilder.getEntity()));
//
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
//        Mockito.verify(roleService, Mockito.times(1)).findById(1L);
//        Mockito.verifyNoMoreInteractions(roleService);
//    }
//
//    @Test
//    public void save() throws Exception {
//        Mockito.when(roleMapper.asEntity(ArgumentMatchers.any())).thenReturn(RoleBuilder.getEntity());
//        Mockito.when(roleService.save(ArgumentMatchers.any(Role.class))).thenReturn(RoleBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.post(ENDPOINT_URL)
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(RoleBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//        Mockito.verify(roleService, Mockito.times(1)).save(ArgumentMatchers.any(Role.class));
//        Mockito.verifyNoMoreInteractions(roleService);
//    }
//
//    @Test
//    public void update() throws Exception {
//        Mockito.when(roleMapper.asEntity(ArgumentMatchers.any())).thenReturn(RoleBuilder.getEntity());
//        Mockito.when(roleService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(RoleBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(RoleBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(roleService, Mockito.times(1)).update(ArgumentMatchers.any(Role.class), ArgumentMatchers.anyLong());
//        Mockito.verifyNoMoreInteractions(roleService);
//    }
//
//    @Test
//    public void delete() throws Exception {
//        Mockito.doNothing().when(roleService).deleteById(ArgumentMatchers.anyLong());
//        mockMvc.perform(
//                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(roleService, Mockito.times(1)).deleteById(Mockito.anyLong());
//        Mockito.verifyNoMoreInteractions(roleService);
//    }
}
