package co.shop.controller;

import co.shop.controller.impl.BranchControllerImpl;
import co.shop.model.mapper.BranchMapper;
import co.shop.model.mapper.ReferenceMapper;
import co.shop.service.BranchService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class BranchControllerImplTest {
    //TODO: create the data Test generator class BranchBuilder
    private static final String ENDPOINT_URL = "/branchs";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private BranchControllerImpl branchController;
    @MockBean
    private BranchService branchService;
    @MockBean
    private BranchMapper branchMapper;
    @Autowired
    private MockMvc mockMvc;

//    @Before
//    public void setup() {
//        this.mockMvc = MockMvcBuilders.standaloneSetup(this.branchController).build();
//    }
//
//    @Test
//    public void getAll() throws Exception {
//        Mockito.when(branchMapper.asDTOList(ArgumentMatchers.any())).thenReturn(BranchBuilder.getListDTO());
//
//        Mockito.when(branchService.findAll()).thenReturn(BranchBuilder.getListEntities());
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
//        Mockito.when(branchMapper.asDTO(ArgumentMatchers.any())).thenReturn(BranchBuilder.getDTO());
//
//        Mockito.when(branchService.findById(ArgumentMatchers.anyInteger())).thenReturn(java.util.Optional.of(BranchBuilder.getEntity()));
//
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
//        Mockito.verify(branchService, Mockito.times(1)).findById(1L);
//        Mockito.verifyNoMoreInteractions(branchService);
//    }
//
//    @Test
//    public void save() throws Exception {
//        Mockito.when(branchMapper.asEntity(ArgumentMatchers.any())).thenReturn(BranchBuilder.getEntity());
//        Mockito.when(branchService.save(ArgumentMatchers.any(Branch.class))).thenReturn(BranchBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.post(ENDPOINT_URL)
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(BranchBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//        Mockito.verify(branchService, Mockito.times(1)).save(ArgumentMatchers.any(Branch.class));
//        Mockito.verifyNoMoreInteractions(branchService);
//    }
//
//    @Test
//    public void update() throws Exception {
//        Mockito.when(branchMapper.asEntity(ArgumentMatchers.any())).thenReturn(BranchBuilder.getEntity());
//        Mockito.when(branchService.update(ArgumentMatchers.any(), ArgumentMatchers.anyInteger())).thenReturn(BranchBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(BranchBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(branchService, Mockito.times(1)).update(ArgumentMatchers.any(Branch.class), ArgumentMatchers.anyInteger());
//        Mockito.verifyNoMoreInteractions(branchService);
//    }
//
//    @Test
//    public void delete() throws Exception {
//        Mockito.doNothing().when(branchService).deleteById(ArgumentMatchers.anyInteger());
//        mockMvc.perform(
//                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(branchService, Mockito.times(1)).deleteById(Mockito.anyInteger());
//        Mockito.verifyNoMoreInteractions(branchService);
//    }
    }
