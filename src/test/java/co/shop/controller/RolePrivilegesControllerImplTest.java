package co.shop.controller;

import co.shop.controller.CustomUtils;
import co.shop.controller.impl.RolePrivilegesControllerImpl;
import co.shop.model.mapper.RolePrivilegesMapper;
import co.shop.service.RolePrivilegesService;
import co.shop.model.entity.user.RolePrivileges;
import co.shop.model.mapper.ReferenceMapper;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class RolePrivilegesControllerImplTest {
    //TODO: create the data Test generator class RolePrivilegesBuilder
    private static final String ENDPOINT_URL = "/role-privilegess";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private RolePrivilegesControllerImpl roleprivilegesController;
    @MockBean
    private RolePrivilegesService roleprivilegesService;
    @MockBean
    private RolePrivilegesMapper roleprivilegesMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.roleprivilegesController).build();
    }

//    @Test
//    public void getAll() throws Exception {
//        Mockito.when(roleprivilegesMapper.asDTOList(ArgumentMatchers.any())).thenReturn(RolePrivilegesBuilder.getListDTO());
//
//        Mockito.when(roleprivilegesService.findAll()).thenReturn(RolePrivilegesBuilder.getListEntities());
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
//        Mockito.when(roleprivilegesMapper.asDTO(ArgumentMatchers.any())).thenReturn(RolePrivilegesBuilder.getDTO());
//
//        Mockito.when(roleprivilegesService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(RolePrivilegesBuilder.getEntity()));
//
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
//        Mockito.verify(roleprivilegesService, Mockito.times(1)).findById(1L);
//        Mockito.verifyNoMoreInteractions(roleprivilegesService);
//    }
//
//    @Test
//    public void save() throws Exception {
//        Mockito.when(roleprivilegesMapper.asEntity(ArgumentMatchers.any())).thenReturn(RolePrivilegesBuilder.getEntity());
//        Mockito.when(roleprivilegesService.save(ArgumentMatchers.any(RolePrivileges.class))).thenReturn(RolePrivilegesBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.post(ENDPOINT_URL)
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(RolePrivilegesBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//        Mockito.verify(roleprivilegesService, Mockito.times(1)).save(ArgumentMatchers.any(RolePrivileges.class));
//        Mockito.verifyNoMoreInteractions(roleprivilegesService);
//    }
//
//    @Test
//    public void update() throws Exception {
//        Mockito.when(roleprivilegesMapper.asEntity(ArgumentMatchers.any())).thenReturn(RolePrivilegesBuilder.getEntity());
//        Mockito.when(roleprivilegesService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(RolePrivilegesBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(RolePrivilegesBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(roleprivilegesService, Mockito.times(1)).update(ArgumentMatchers.any(RolePrivileges.class), ArgumentMatchers.anyLong());
//        Mockito.verifyNoMoreInteractions(roleprivilegesService);
//    }
//
//    @Test
//    public void delete() throws Exception {
//        Mockito.doNothing().when(roleprivilegesService).deleteById(ArgumentMatchers.anyLong());
//        mockMvc.perform(
//                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(roleprivilegesService, Mockito.times(1)).deleteById(Mockito.anyLong());
//        Mockito.verifyNoMoreInteractions(roleprivilegesService);
//    }
}
