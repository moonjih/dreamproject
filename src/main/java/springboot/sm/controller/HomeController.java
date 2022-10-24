package springboot.sm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springboot.sm.domain.Basket;
import springboot.sm.mapper.BasketMapper;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BasketMapper basketMapper;

    @GetMapping("/")
    public void hello(){
        System.out.println("사랑");
    }

    @GetMapping("/cart")
    public String cart(Model model, int cartId ) {
        List<Basket> list = basketMapper.findBasketAll();
        list.forEach(i-> System.out.println(i));
       model.addAttribute("list" ,list);
       return "cart/list";
    }
}
