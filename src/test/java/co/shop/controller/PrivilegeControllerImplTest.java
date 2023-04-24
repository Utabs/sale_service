package co.shop.controller;

import co.shop.controller.impl.PrivilegeControllerImpl;
import co.shop.model.mapper.PrivilegeMapper;
import co.shop.model.mapper.ReferenceMapper;
import co.shop.service.PrivilegeService;
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
public class PrivilegeControllerImplTest {
    //TODO: create the data Test generator class PrivilegeBuilder
    private static final String ENDPOINT_URL = "/privileges";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private PrivilegeControllerImpl privilegeController;
    @MockBean
    private PrivilegeService privilegeService;
    @MockBean
    private PrivilegeMapper privilegeMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.privilegeController).build();
    }
//
//    @Test
//    public void getAll() throws Exception {
//        Mockito.when(privilegeMapper.asDTOList(ArgumentMatchers.any())).thenReturn(PrivilegeBuilder.getListDTO());
//
//        Mockito.when(privilegeService.findAll()).thenReturn(PrivilegeBuilder.getListEntities());
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
//        Mockito.when(privilegeMapper.asDTO(ArgumentMatchers.any())).thenReturn(PrivilegeBuilder.getDTO());
//
//        Mockito.when(privilegeService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(PrivilegeBuilder.getEntity()));
//
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
//        Mockito.verify(privilegeService, Mockito.times(1)).findById(1L);
//        Mockito.verifyNoMoreInteractions(privilegeService);
//    }
//
//    @Test
//    public void save() throws Exception {
//        Mockito.when(privilegeMapper.asEntity(ArgumentMatchers.any())).thenReturn(PrivilegeBuilder.getEntity());
//        Mockito.when(privilegeService.save(ArgumentMatchers.any(Privilege.class))).thenReturn(PrivilegeBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.post(ENDPOINT_URL)
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(PrivilegeBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//        Mockito.verify(privilegeService, Mockito.times(1)).save(ArgumentMatchers.any(Privilege.class));
//        Mockito.verifyNoMoreInteractions(privilegeService);
//    }
//
//    @Test
//    public void update() throws Exception {
//        Mockito.when(privilegeMapper.asEntity(ArgumentMatchers.any())).thenReturn(PrivilegeBuilder.getEntity());
//        Mockito.when(privilegeService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(PrivilegeBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(PrivilegeBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(privilegeService, Mockito.times(1)).update(ArgumentMatchers.any(Privilege.class), ArgumentMatchers.anyLong());
//        Mockito.verifyNoMoreInteractions(privilegeService);
//    }
//
//    @Test
//    public void delete() throws Exception {
//        Mockito.doNothing().when(privilegeService).deleteById(ArgumentMatchers.anyLong());
//        mockMvc.perform(
//                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(privilegeService, Mockito.times(1)).deleteById(Mockito.anyLong());
//        Mockito.verifyNoMoreInteractions(privilegeService);
//    }
}
