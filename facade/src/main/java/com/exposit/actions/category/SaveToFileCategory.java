package com.exposit.actions.category;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import com.exposit.menu.Facade;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveToFileCategory extends AbstractAction implements IAction {


    private static final Logger LOG = LoggerFactory.getLogger(SaveToFileCategory.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            facade.saveCategoryToFile();
            System.out.println("categories successfully saved to file");
        } catch (Exception e) {
            LOG.error("can not save to file category");
        }
    }
}
