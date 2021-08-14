Create table moedas(
	varBid numeric(5,4),
	code char(3),
	codein char(3),
	name varchar(255),
	high numeric(10,4),
	low numeric(10,4),
	pctChange numeric(5,4),
	bid numeric(10,4),
	ask numeric(10,4),
	timeStamp timestamp
);

insert into moedas(varBid, code, codein, name, high, low, pctChange, bid, ask, timeStamp)
values (-0.0143, 'USD', 'BRL', 'Dólar Americano/Real Brasileiro', 3.8906, 3.8596, -0.37, 3.8659, 3.8671, '2019-04-15 17:35:43');

insert into moedas(varBid, code, codein, name, high, low, pctChange, bid, ask, timeStamp)
values (-0.0143, 'USD', 'BRL', 'OUTRA MOEDA 1', 3.8906, 3.8596, -0.37, 3.8659, 3.8671, '2019-04-15 17:35:43');

insert into moedas(varBid, code, codein, name, high, low, pctChange, bid, ask, timeStamp)
values (-0.0143, 'USD', 'BRL', 'OUTRA MOEDA 2', 3.8906, 3.8596, -0.37, 3.8659, 3.8671, '2019-04-15 17:35:43');

insert into moedas(varBid, code, codein, name, high, low, pctChange, bid, ask, timeStamp)
values (-0.0143, 'USD', 'BRL', 'OUTRA MOEDA 3', 3.8906, 3.8596, -0.37, 3.8659, 3.8671, '2019-04-15 17:35:43');