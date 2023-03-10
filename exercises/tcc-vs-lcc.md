# TCC *vs* LCC

Explain under which circumstances *Tight Class Cohesion* (TCC) and *Loose Class Cohesion* (LCC) metrics produce the same value for a given Java class. Build an example of such as class and include the code below or find one example in an open-source project from Github and include the link to the class below. Could LCC be lower than TCC for any given class? Explain.

## Answer

In order to detect 3 nested if statements using PMD, we used a ruleset containing one rule as follow : <ruleset
        name="myruleset"
        descriprion="ruleset de test">
<rule name="3ifstatements"
      language="java"
      message="3ifs"
      class="net.sourceforge.pmd.lang.rule.XPathRule" >
    <description>
    detects 3 if statements in a row
    </description>
    <priority>3</priority>
    <properties>
        <property name="xpath">
                <value>
       <![CDATA[
                //IfStatement[descendant::IfStatement[count(descendant::IfStatement) >= 2]]
       ]]>
            </value>
        </property>
    </properties>
        </rule>
</ruleset>
~                                                                                                                                             
~                      
