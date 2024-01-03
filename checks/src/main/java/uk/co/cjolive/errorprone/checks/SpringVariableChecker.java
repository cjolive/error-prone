package uk.co.cjolive.errorprone.checks;

import com.google.auto.service.AutoService;
import com.google.errorprone.BugPattern;
import com.google.errorprone.VisitorState;
import com.google.errorprone.bugpatterns.BugChecker;
import com.google.errorprone.fixes.SuggestedFixes;
import com.google.errorprone.matchers.Description;
import com.google.errorprone.util.ASTHelpers;
import com.sun.source.tree.VariableTree;

@AutoService(BugChecker.class)
@BugPattern(name = "MyCheck", summary = "My check", severity = BugPattern.SeverityLevel.WARNING)
public class SpringVariableChecker extends BugChecker implements BugChecker.VariableTreeMatcher {


    @Override
    public Description matchVariable(VariableTree variableTree, VisitorState visitorState) {
        String message = "ARRRGGGHHH";
        return this.buildDescription(variableTree).setMessage(message).build();

    }
}
