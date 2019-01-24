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
  /**
   * Load the new widget page.
   * @param model
   * @return
   */
  @GetMapping("/payanycard/new")
  public String newWidget(Model model) {
    model.addAttribute("payanycard", new PayAnyCard());
    return "payanycardform";
  }
  /**
   * Create a new widget.
   * @param payAnyCard
   * @param model
   * @return
   */
  @PostMapping("/payanycard")
  public String createWidget(PayAnyCard payAnyCard, Model model) {
    payAnyCardRepo.save(payAnyCard);
    return "redirect:/admin/payanycard/" + payAnyCard.getId();
  }
  /**
   * Get a widget by ID.
   * @param id
   * @param model
   * @return
   */
  @GetMapping("/payanycard/{id}")
  public String getWidgetById(@PathVariable Long id, Model model) {
    model.addAttribute("payanycard", payAnyCardRepo.findById(id).orElse(new PayAnyCard()));
    return "payanycard";
  }
  /**
   * Get all widgets.
   * @param model
   * @return
   */
  @GetMapping("/payanycards")
  public String getWidgets(Model model) {
    model.addAttribute("payanycards", payAnyCardRepo.findAll());
    return "payanycards";
  }
  /**
   * Load the edit widget page for the widget with the specified ID.
   * @param id
   * @param model
   * @return
   */
  @GetMapping("/payanycard/edit/{id}")
  public String editWidget(@PathVariable Long id, Model model) {
    model.addAttribute("payanycard", payAnyCardRepo.findById(id).orElse(new PayAnyCard()));
    return "payanycardform";
  }
  /**
   * Update a widget.
   * @param payAnyCard
   * @return
   */
  @PostMapping("/payanycard/{id}")
  public String updateWidget(PayAnyCard payAnyCard) {
    payAnyCardRepo.save(payAnyCard);
    return "redirect:/admin/payanycard/" + payAnyCard.getId();
  }
  /**
   * Delete a widget by ID.
   * @param id
   * @return
   */
  @GetMapping("/payanycard/delete/{id}")
  public String deleteWidget(@PathVariable  Long id) {
    payAnyCardRepo.deleteById(id);
    return "redirect:/admin/payanycards";
  }
}
