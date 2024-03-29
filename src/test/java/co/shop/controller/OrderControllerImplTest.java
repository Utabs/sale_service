package co.shop.controller;


import co.shop.controller.impl.OrderControllerImpl;
import co.shop.model.mapper.OrderMapper;
import co.shop.model.mapper.ReferenceMapper;
import co.shop.service.OrderService;
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
public class OrderControllerImplTest {
    //TODO: create the data Test generator class OrderBuilder
    private static final String ENDPOINT_URL = "/orders";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private OrderControllerImpl orderController;
    @MockBean
    private OrderService orderService;
    @MockBean
    private OrderMapper orderMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.orderController).build();
    }
//
//    @Test
//    public void getAll() throws Exception {
//        Mockito.when(orderMapper.asDTOList(ArgumentMatchers.any())).thenReturn(OrderBuilder.getListDTO());
//
//        Mockito.when(orderService.findAll()).thenReturn(OrderBuilder.getListEntities());
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
//        Mockito.when(orderMapper.asDTO(ArgumentMatchers.any())).thenReturn(OrderBuilder.getDTO());
//
//        Mockito.when(orderService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(OrderBuilder.getEntity()));
//
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
//        Mockito.verify(orderService, Mockito.times(1)).findById(1L);
//        Mockito.verifyNoMoreInteractions(orderService);
//    }
//
//    @Test
//    public void save() throws Exception {
//        Mockito.when(orderMapper.asEntity(ArgumentMatchers.any())).thenReturn(OrderBuilder.getEntity());
//        Mockito.when(orderService.save(ArgumentMatchers.any(Order.class))).thenReturn(OrderBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.post(ENDPOINT_URL)
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(OrderBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//        Mockito.verify(orderService, Mockito.times(1)).save(ArgumentMatchers.any(Order.class));
//        Mockito.verifyNoMoreInteractions(orderService);
//    }
//
//    @Test
//    public void update() throws Exception {
//        Mockito.when(orderMapper.asEntity(ArgumentMatchers.any())).thenReturn(OrderBuilder.getEntity());
//        Mockito.when(orderService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(OrderBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(OrderBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(orderService, Mockito.times(1)).update(ArgumentMatchers.any(Order.class), ArgumentMatchers.anyLong());
//        Mockito.verifyNoMoreInteractions(orderService);
//    }
//
//    @Test
//    public void delete() throws Exception {
//        Mockito.doNothing().when(orderService).deleteById(ArgumentMatchers.anyLong());
//        mockMvc.perform(
//                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(orderService, Mockito.times(1)).deleteById(Mockito.anyLong());
//        Mockito.verifyNoMoreInteractions(orderService);
//    }
}
