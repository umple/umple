package cruise.umplificator.rules;

import java.util.Iterator;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import cruise.umplificator.core.Umplificator;
import cruise.umplificator.parser.JavaParser;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    @SuppressWarnings("restriction")
	public static final void main(String[] args) {
        try {
            // load up the knowledge base (rules)
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	
        	JavaParser javaParser = new JavaParser(new Umplificator());
        	javaParser.parse("class A {public int age;}");

        	CompilationUnit compilationUnit = javaParser.parse("class A {}");
        	AST ast= compilationUnit.getAST();
        	VariableDeclarationFragment fragment = ast.newVariableDeclarationFragment();
        	fragment.setName(ast.newSimpleName("b"));
        	final FieldDeclaration declaration = ast.newFieldDeclaration(fragment);
        	declaration.setType(ast.newPrimitiveType(PrimitiveType.INT));
        	
        	VariableDeclarationFragment fragment2 = ast.newVariableDeclarationFragment();
        	fragment2.setName(ast.newSimpleName("log"));
        	final FieldDeclaration declaration2 = ast.newFieldDeclaration(fragment2);
        	declaration2.setType(ast.newSimpleType(ast.newName("Logger")));
           
        	kSession.insert(declaration);
          	kSession.insert(declaration2);
            kSession.fireAllRules();
          
            QueryResults q = kSession.getQueryResults("fieldDeclarations");
            
            for ( Iterator<?> it = q.iterator(); it.hasNext(); ) {
                QueryResultsRow qResult = (QueryResultsRow)it.next();
                FieldDeclaration field = ( FieldDeclaration)qResult.get("fieldDeclaration");
                System.out.print(field.getType().isPrimitiveType());
            }
            
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
