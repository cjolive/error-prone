package uk.co.cjolive.errorprone.checks;

import com.google.auto.service.AutoService;
import com.google.errorprone.BugPattern;
import com.google.errorprone.VisitorState;
import com.google.errorprone.bugpatterns.BugChecker;
import com.google.errorprone.matchers.Description;
import com.google.errorprone.util.ASTHelpers;
import com.sun.tools.javac.code.Symbol;
import com.sun.source.tree.VariableTree;

import javax.lang.model.element.ElementKind;

// see https://github.com/google/error-prone/tree/master/core/src/main/java/com/google/errorprone/bugpatterns
// for existing rules to copy
@AutoService(BugChecker.class)
@BugPattern(name = "PrivateCheck", summary = "Check variables are private", severity = BugPattern.SeverityLevel.WARNING)
public class PrivateVariableChecker extends BugChecker implements BugChecker.VariableTreeMatcher {

    @Override
    public Description matchVariable(VariableTree variableTree, VisitorState visitorState) {

        Symbol sym = ASTHelpers.getSymbol(variableTree);

        if (sym.getKind() == ElementKind.FIELD && !sym.isPrivate()) {
            String message = "Non private field found, make private";
            return this.buildDescription(variableTree).setMessage(message).build();
        }

        return Description.NO_MATCH;
    }
}
