package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.console.action.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Configuration
class ConsoleUIConfiguration {


//    private final Action createProductAction;
//    private final Action findProductByIdAction;
//    private final Action exitAction;
//    private final Action createUserAction;
//    private final Action findUserByIDAction;

    @Autowired
//    @Qualifier ("createProductAction")
    private Action createProductAction;

    @Autowired
//    @Qualifier("findProductByIdAction")
    private Action findProductByIdAction;

    @Autowired
//    @Qualifier("exitAction")
    private Action exitAction;

    @Autowired
//    @Qualifier("createUserAction")
    private Action createUserAction;

    @Autowired
//    @Qualifier("findUserByIdAction")
    private Action findUserByIdAction;

    @Autowired
    private Action assignProductAction;

//    @Autowired
//    public ConsoleUIConfiguration (@Qualifier("createProductMenu") Action createProductAction,
//            @Qualifier("findProductByIdAction") Action findProductByIdAction,
//            @Qualifier(value = "exitAction") Action exitAction,
//            @Qualifier(value = "createUserAction") Action createUserAction,
//            @Qualifier(value = "findUserByIDAction") Action findUserByIDAction) {
//        this.createProductAction = createProductAction;
//        this.findProductByIdAction = findProductByIdAction;
//        this.exitAction = exitAction;
//        this.createUserAction = createUserAction;
//        this.findUserByIDAction = findUserByIDAction;
//    }

//    @Autowired
//    public ConsoleUIConfiguration(Action createProductAction,
//                                  Action findProductByIdAction,
//                                  Action exitAction,
//                                  Action createUserAction,
//                                  Action findUserByIDAction) {
//        this.createProductAction = createProductAction;
//        this.findProductByIdAction = findProductByIdAction;
//        this.exitAction = exitAction;
//        this.createUserAction = createUserAction;
//        this.findUserByIDAction = findUserByIDAction;
//    }

    @Bean
    ConsoleUI consoleUI() {
        List<Action> actions = new ArrayList<>();
        actions.add(createProductAction);
        actions.add(findProductByIdAction);
        actions.add(createUserAction);
        actions.add(findUserByIdAction);
        actions.add(assignProductAction);
        actions.add(exitAction);
        return new ConsoleUI(actions);
    }
}
