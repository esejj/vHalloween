command /event [<text>]:
	trigger:
		if arg 1 is "dolacz" or "join":
			if {eventhalloween::status::%player%} is "&aUdzial":
				if {event::list::*} doesn't contains "%player%":
					add "%player%" to {event::list::*}
					send coloured "&7Dolaczyles do &3eventu" to the player
			else:
				send "&cWpisz /dynia aby wziac udzial!" to the player
		stop

every 10 minutes:
	loop {event::list::*}:
		add 1 to {_x}
		set {_x2} to a random integer between 1 and size of {event::list::*}
		if {_x} = {_x2}:
			set {_winner} to loop-index
			exit loop
			set {_item} to a random item out of all items
			broadcast "&6%{_winner}% &7wygral &3%{_item}%"
			wait 3 seconds
			add "%{_item}%" to the {_winner}'s inventory
	clear {event::list::*}
