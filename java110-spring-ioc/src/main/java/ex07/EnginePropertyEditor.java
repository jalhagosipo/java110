package ex07;

import java.beans.PropertyEditorSupport;

public class EnginePropertyEditor extends PropertyEditorSupport{

    public EnginePropertyEditor() {
        System.out.println("EnginePropertyEditor() 호출됨!");
    }
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        
        System.out.println("EnginePropertyEditor.setText(String)");
        
        String str[] = text.split(",");
        
        Engine e = new Engine();
        e.setMaker(str[0]);
        e.setValve(Integer.parseInt(str[1]));
        e.setDiesel(Boolean.parseBoolean(str[2]));

        this.setValue(e);
    }
    
    @Override
    public Object getValue() {
        
        System.out.println("EnginePropertyEditor.getValue()");
        return super.getValue();
    }
}
