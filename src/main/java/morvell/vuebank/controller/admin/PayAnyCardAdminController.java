package morvell.vuebank.controller.admin;

import morvell.vuebank.domain.PayAnyCard;
import morvell.vuebank.repo.PayAnyCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class PayAnyCardAdminController {

  @Autowired
  private PayAnyCardRepo payAnyCardRepo;

  @GetMapping("/payanycard/new")
  public String newPayAnyCard(Model model) {
    model.addAttribute("payanycard", new PayAnyCard());
    return "payanycardform";
  }

  @PostMapping("/payanycard")
  public String createPayAnyCard(PayAnyCard payAnyCard, Model model) {
    payAnyCardRepo.save(payAnyCard);
    return "redirect:/admin/payanycard/" + payAnyCard.getId();
  }

  @GetMapping("/payanycard/{id}")
  public String getPayAnyCardById(@PathVariable Long id, Model model) {
    model.addAttribute("payanycard", payAnyCardRepo.findById(id).orElse(new PayAnyCard()));
    return "payanycard";
  }

  @GetMapping("/payanycards")
  public String getPayAnyCards(Model model) {
    model.addAttribute("payanycards", payAnyCardRepo.findAll());
    return "payanycards";
  }

  @GetMapping("/payanycard/edit/{id}")
  public String editPayAnyCard(@PathVariable Long id, Model model) {
    model.addAttribute("payanycard", payAnyCardRepo.findById(id).orElse(new PayAnyCard()));
    return "payanycardform";
  }

  @PostMapping("/payanycard/{id}")
  public String updatePayAnyCard(PayAnyCard payAnyCard) {
    payAnyCardRepo.save(payAnyCard);
    return "redirect:/admin/payanycard/" + payAnyCard.getId();
  }

  @GetMapping("/payanycard/delete/{id}")
  public String deletePayAnyCard(@PathVariable Long id) {
    payAnyCardRepo.deleteById(id);
    return "redirect:/admin/payanycards";
  }
}
