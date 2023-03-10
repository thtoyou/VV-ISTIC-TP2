# Code of your exercise

<ruleset
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
                <value><![CDATA[
                    //IfStatement[descendant::IfStatement[count(descendant::IfStatement) >= 2]]]]>
                </value>
            </property>
        </properties>
    </rule>
</ruleset>
