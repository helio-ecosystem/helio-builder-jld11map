<#assign jpath=handlers("JsonHandler")>
<#assign data=providers("FileProvider", { "file" : "./src/test/resources/data-samples/sample3.json"})>

"iso utc timestamp", "active power", "reactive inductive power", "reactive capacitive power", "voltage"
<#list jpath.filter("$.*",data) as row>
"[=jpath.filter("$.iso_utc_timestamp",row)]", "[=jpath.filter("$.active_power",row)]", "[=jpath.filter("$.reactive_inductive_power",row)]", "[=jpath.filter("$.reactive_capacitive_power",row)]", "[=jpath.filter("$.voltage",row)]"
</#list>
