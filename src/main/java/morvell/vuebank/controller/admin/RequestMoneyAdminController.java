package morvell.vuebank.controller.admin;

import morvell.vuebank.domain.PayAnyCard;
import morvell.vuebank.domain.RequestMoney;
import morvell.vuebank.repo.RequestMoneyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class RequestMoneyAdminController {

  @Autowired
  private RequestMoneyRepo repo;

  @GetMapping("/requestmoney/new")
  public String newRequestMoney(Model model) {
    model.addAttribute("requestMoney", new RequestMoney());
    return "requestmoneyform";
  }

  @PostMapping("/requestmoney")
  public String createRequestMoney(RequestMoney requestMoney, Model model) {
    repo.save(requestMoney);
    return "redirect:/admin/requestmoney/" + requestMoney.getId();
  }

  @GetMapping("/requestmoney/{id}")
  public String getRequestMoneyById(@PathVariable Long id, Model model) {
    model.addAttribute("requestmoney", repo.findById(id).orElse(new RequestMoney()));
    return "requestmoney";
  }

  @GetMapping("/requestmoneys")
  public String getRequestMoneys(Model model) {
    model.addAttribute("requestmoneys", repo.findAll());
    return "requestmoneys";
  }

  @GetMapping("/requestmoney/edit/{id}")
  public String editRequestMoney(@PathVariable Long id, Model model) {
    model.addAttribute("requestmoney", repo.findById(id).orElse(new RequestMoney()));
    return "requestmoneyform";
  }

  @PostMapping("/requestmoney/{id}")
  public String updateRequestMoney(RequestMoney requestMoney) {
    repo.save(requestMoney);
    return "redirect:/admin/requestmoney/" + requestMoney.getId();
  }

  @GetMapping("/requestmoney/delete/{id}")
  public String deleteRequestMoney(@PathVariable Long id) {
    repo.deleteById(id);
    return "redirect:/admin/requestmoneys";
  }

}
