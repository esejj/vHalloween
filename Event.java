command /event [<text>]:
	trigger:
		if arg 1 is "dolacz" or "join":
			if {eventhalloween::status::%player%} is "&aUdzial":
				add "%player%" to {event::list::*}
				send coloured "&7Dolacyzles do &3eventu" to the player
			else:
				send "&cWpisz /dynia aby wziac udzial!" to the player
		stop
