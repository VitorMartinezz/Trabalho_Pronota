package front.services.validators;

import com.jfoenix.validation.base.ValidatorBase;
import javafx.scene.control.TextInputControl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfirmPWValidator extends ValidatorBase {
    String password;
    public ConfirmPWValidator(String password, String message) {
        super(message);
        this.password = password;
    }

    public ConfirmPWValidator(String password) {
        this.password = password;
    }

    @Override
    protected void eval() {
        if (srcControl.get() instanceof TextInputControl) {
            TextInputControl textField = (TextInputControl) srcControl.get();
            String text = textField.getText();

            if(!password.matches(text)) {
                hasErrors.set(true);
            } else {
                hasErrors.set(false);
            }
        }
    }
}
