# CUKIEREK ALBO PSIKUS!! :)
variables:
	{eventhalloween::status::%player%} = "&cBrak udzialu"

on first join:
	send coloured "&cWitamy! &7Obecnie prowadzony jest event halloween!" to the player
	send coloured "&cAby dolaczyc wpisz &3/dynia" to the player
	stop


command /eventhalloween:dynia [<text>]:
	description: Zarzadzanie dynia.
	permission: eventhalloween.dynia
	usage: Uzyj /dynia
	aliases: /dynia
	trigger:
		wait 5 ticks
		open chest with 3 rows named "&8&k╦ &6Zarzadzanie dynia &8&k╦" to the player
		loop 27 times:
			if loop-number is 14:
				set {ccc::119::%player%} to a random integer between 0 and 34523
				format slot (loop-number - 1) of player with pumpkin named "&6Zarzadzanie dynia" with lore "&8• &7Status: %{eventhalloween::status::%player%}%" to close then run [make player execute command "ad1 %{ccc::119::%player%}%"]
			else:
				format slot (loop-number - 1) of player with 1 of black stained glass pane named "&8Background" to be unstealable
command /ad1 [<text>]:
	trigger:
		if argument 1 is {ccc::119::%player%}
			make player execute command "Dynia"
			if {eventhallowen::status::%player%} is "&cBrak udzialu":
				if helmet of the player isn't air:
					set {recovery::helmet::%player%} to helmet of the player
				set helmet of the player to pumpkin
				send coloured "&2Dziekujemy za wziecie udzialu w evencie! &7To mile z twojej strony!" to the player
				set {eventhalloween::status::%player%} to "&aUdzial"
			if {eventhalloween::status::%player%} is "&aUdzial":
				if {recovery::helmet::%player%} isn't set:
					set helmet of the player to air
				clear {recovery::helmet::%player%}
				send coloured "&2Dziekujemy za wziecie udzialu w evencie! &7To mile z twojej strony!" to the player
				set {eventhalloween::status::%player%} to "&cBrak udzialu"
			clear {ccc::119::%player%}
		else:
			send coloured "&fUnknown command. Type ""help"" for help." to the player

