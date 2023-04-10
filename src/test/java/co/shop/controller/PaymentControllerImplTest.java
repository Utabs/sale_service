package co.shop.controller;

import co.shop.controller.impl.PaymentControllerImpl;
import co.shop.model.mapper.PaymentMapper;
import co.shop.model.mapper.ReferenceMapper;
import co.shop.service.PaymentService;
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
public class PaymentControllerImplTest {
    //TODO: create the data Test generator class PaymentBuilder
    private static final String ENDPOINT_URL = "/payments";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private PaymentControllerImpl paymentController;
    @MockBean
    private PaymentService paymentService;
    @MockBean
    private PaymentMapper paymentMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.paymentController).build();
    }
//
//    @Test
//    public void getAll() throws Exception {
//        Mockito.when(paymentMapper.asDTOList(ArgumentMatchers.any())).thenReturn(PaymentBuilder.getListDTO());
//
//        Mockito.when(paymentService.findAll()).thenReturn(PaymentBuilder.getListEntities());
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
//        Mockito.when(paymentMapper.asDTO(ArgumentMatchers.any())).thenReturn(PaymentBuilder.getDTO());
//
//        Mockito.when(paymentService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(PaymentBuilder.getEntity()));
//
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
//        Mockito.verify(paymentService, Mockito.times(1)).findById(1L);
//        Mockito.verifyNoMoreInteractions(paymentService);
//    }
//
//    @Test
//    public void save() throws Exception {
//        Mockito.when(paymentMapper.asEntity(ArgumentMatchers.any())).thenReturn(PaymentBuilder.getEntity());
//        Mockito.when(paymentService.save(ArgumentMatchers.any(Payment.class))).thenReturn(PaymentBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.post(ENDPOINT_URL)
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(PaymentBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//        Mockito.verify(paymentService, Mockito.times(1)).save(ArgumentMatchers.any(Payment.class));
//        Mockito.verifyNoMoreInteractions(paymentService);
//    }
//
//    @Test
//    public void update() throws Exception {
//        Mockito.when(paymentMapper.asEntity(ArgumentMatchers.any())).thenReturn(PaymentBuilder.getEntity());
//        Mockito.when(paymentService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(PaymentBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(PaymentBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(paymentService, Mockito.times(1)).update(ArgumentMatchers.any(Payment.class), ArgumentMatchers.anyLong());
//        Mockito.verifyNoMoreInteractions(paymentService);
//    }
//
//    @Test
//    public void delete() throws Exception {
//        Mockito.doNothing().when(paymentService).deleteById(ArgumentMatchers.anyLong());
//        mockMvc.perform(
//                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(paymentService, Mockito.times(1)).deleteById(Mockito.anyLong());
//        Mockito.verifyNoMoreInteractions(paymentService);
//    }
}
