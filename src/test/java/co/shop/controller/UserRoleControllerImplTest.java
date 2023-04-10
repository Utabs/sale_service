package co.shop.controller;

import co.shop.controller.CustomUtils;
import co.shop.controller.impl.UserRoleControllerImpl;
import co.shop.model.mapper.UserRoleMapper;
import co.shop.service.UserRoleService;
import co.shop.model.entity.user.UserRole;
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
public class UserRoleControllerImplTest {
    //TODO: create the data Test generator class UserRoleBuilder
    private static final String ENDPOINT_URL = "/user-roles";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private UserRoleControllerImpl userroleController;
    @MockBean
    private UserRoleService userroleService;
    @MockBean
    private UserRoleMapper userroleMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.userroleController).build();
    }
//
//    @Test
//    public void getAll() throws Exception {
//        Mockito.when(userroleMapper.asDTOList(ArgumentMatchers.any())).thenReturn(UserRoleBuilder.getListDTO());
//
//        Mockito.when(userroleService.findAll()).thenReturn(UserRoleBuilder.getListEntities());
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
//        Mockito.when(userroleMapper.asDTO(ArgumentMatchers.any())).thenReturn(UserRoleBuilder.getDTO());
//
//        Mockito.when(userroleService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(UserRoleBuilder.getEntity()));
//
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
//        Mockito.verify(userroleService, Mockito.times(1)).findById(1L);
//        Mockito.verifyNoMoreInteractions(userroleService);
//    }
//
//    @Test
//    public void save() throws Exception {
//        Mockito.when(userroleMapper.asEntity(ArgumentMatchers.any())).thenReturn(UserRoleBuilder.getEntity());
//        Mockito.when(userroleService.save(ArgumentMatchers.any(UserRole.class))).thenReturn(UserRoleBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.post(ENDPOINT_URL)
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(UserRoleBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//        Mockito.verify(userroleService, Mockito.times(1)).save(ArgumentMatchers.any(UserRole.class));
//        Mockito.verifyNoMoreInteractions(userroleService);
//    }
//
//    @Test
//    public void update() throws Exception {
//        Mockito.when(userroleMapper.asEntity(ArgumentMatchers.any())).thenReturn(UserRoleBuilder.getEntity());
//        Mockito.when(userroleService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(UserRoleBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(UserRoleBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(userroleService, Mockito.times(1)).update(ArgumentMatchers.any(UserRole.class), ArgumentMatchers.anyLong());
//        Mockito.verifyNoMoreInteractions(userroleService);
//    }
//
//    @Test
//    public void delete() throws Exception {
//        Mockito.doNothing().when(userroleService).deleteById(ArgumentMatchers.anyLong());
//        mockMvc.perform(
//                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(userroleService, Mockito.times(1)).deleteById(Mockito.anyLong());
//        Mockito.verifyNoMoreInteractions(userroleService);
//    }
}
