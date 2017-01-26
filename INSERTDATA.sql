insert into users (`username`,`password`,`firstname`,`lastname`,`ssn`,`type`) values 
	('1','1','alex1','alex1','123',0),
	('2','2','alex2','alex2','123',0),
	('3','3','alex3','alex3','123',1),	
	('4','4','alex3','alex3','123',2);
insert into readers (`username`,`paymentmethod`,`subscription`,`date`,`isfrozen`)
	values ('alex1','12345','monthly',curdate(),1);
insert into readers (`username`) values('alex2');
insert into employees (`username`,`employeeid`,`email`,`department`,`role`)
	values ('alex3','12345','alex3@gmail.com','librarian','librarian'),('alex4','12345','alex4@gmail.com','managment','manager');
/*Books*/
	insert into books(`title`, `language`, `summary`, `tableofcontents` ,`price`) values
	('The Tragedy of Hamlet, Prince of Denmark','English', 
'Hamlet is a tragedy written by William Shakespeare at date between 1599 and 1602.',
'Act 1 .. p.5 \r\nAct 2 .. p.8 \r\nAct 3 .. p.13','87.9' );
	insert into books(`title`, `language`, `summary`, `tableofcontents` ,`price`) values
	('Harry Potter','English', 
'Harry Potter is the most miserable,lonely boy you can imagine. He’s shunned by his relatives, the Dursley’s, that have raised him since he was an infant.',
'1 Dudley Demented p. 12 \r\nA Peck of Owls p. 203 ','87.9' );
	insert into books(`title`, `language`, `summary`, `tableofcontents` ,`price`) values
	('Moby Dick','English', 
'Moby-Dick; or, The Whale is a novel by American writer Herman Melville, published in 1851 during the period of the American Renaissance.',
'Chapter 1\r\nLoomings Chapter 2\r\nThe Carpet-Bag Chapter 3\r\nThe Spouter Inn Chapter 4\r\nThe Counterpane','87.9' );
	insert into books(`title`, `language`, `summary`, `tableofcontents` ,`price`) values
	('The Chronicles of Narnia','English', 
'The Chronicles of Narnia is a series of seven high fantasy novels by C. S. Lewis. It is considered a classic of childrens literature and is the authors best-known work, having sold over 100 million copies in 47 languages.',
'The magicians nephew The lion, the witch and the wardrobe \r\nThe horse and his boy \r\nPrince Caspian \r\nThe voyage of the Dawn Treader \r\nThe silver chair \r\nThe last battle.','87.9' );
	insert into books(`title`, `language`, `summary`, `tableofcontents` ,`price`) values
	('Les trois mousquetaires','French', 
'Le roman raconte les aventures d`un Gascon impécunieux de 18 ans, d`Artagnan, venu à Paris pour faire carrière dans le corps des mousquetaires. Il se lie d`amitié avec Athos, Porthos et Aramis, mousquetaires du roi Louis XIII.',
'Chapitre Ier.Les trois présents de M. d’Artagnan père  5\r\n«V. Les Mousquetaires du Roi et les Gardes de M. le Cardinal 39\r\n« X. Une Souricière au dix-septième siècle 81\r\nXV. Gens de robe et gens d’épée  123\r\nXX.Voyage 161\r\nXXV.La maîtresse de Porthos 198\r\nXXX. Milady 256\r\nXXXV. La nuit tous les chats sont gris 289\r\nXL. Le Cardinal 321\r\nXLV. Scène conjugale 354\r\nL. Causerie d’un frère avec sa sœur 394\r\nLV. Quatrième journée de captivité 427\r\nLX. En France 464\r\nLXV. Le jugement 499\r\nÉpilogue 517','87.9' );
	insert into books(`title`, `language`, `summary`, `tableofcontents` ,`price`) values
	('Anna Karenina','Russian', 
'Anna Karenina tells of the doomed love affair between the sensuous and rebellious Anna and the dashing officer, Count Vronsky. Tragedy unfolds as Anna rejects her passionless marriage and must endure the hypocrisies of society.',
'Part 1\r\nPart 2 \r\nPart 3\r\nPart 4\r\nPart 5\r\nPart 6\r\nPart 7\r\nPart 8','87.9' );
	insert into books(`title`, `language`, `summary`, `tableofcontents` ,`price`) values
	('The Dog Training Guide','English', 
'This FREE Dog Training E-book will help you to: Train your dog using gentle, reward-based methods that work! Prevent and solve common dog behavior problems such as: Barking, Jumping up, Nipping, Pulling on the leash',
'Table of Contents\r\n\r\nPart I Teaching the Humans	3\r\nPart 2: Teaching the Dog	11\r\nPart 3: Problem Solving 	26\r\nThe End – (But you’re Never Done Teaching Your Dog!)	33'
,'87.9' );
	insert into books(`title`, `language`, `summary`, `tableofcontents` ,`price`) values
	('A Brief History of Time','English', 
'Stephen Hawking talks about basic concepts like space and time, basic building blocks that make up the universe (such as quarks) and the fundamental forces that govern it (such as gravity). ',
'Table of contents\r\nChapter 1 - Our Picture of the Universe\r\nChapter 2 - Space and Time\r\nChapter 3 - The Expanding Universe\r\nChapter 4 - The Uncertainty Principle\r\nChapter 5 - Elementary Particles and the Forces of Nature\r\nChapter 6 - Black Holes\r\nChapter 7 - Black Holes Ain`t So Black\r\nChapter 8 - The Origin and Fate of the Universe\r\nChapter 9 - The Arrow of Time\r\nChapter 10 - Wormholes and Time Travel\r\nChapter 11 - The Unification of Physics\r\nChapter 12 - Conclusion'
,'87.9' );
	insert into books(`title`, `language`, `summary`, `tableofcontents` ,`price`) values
	('The Globalization of Human Rights','English', 
'International efforts to construct a set of standardised human rights guidelines are based upon the identification of agreed key values regarding the relationships between individuals and the institutions governing them, which are viewed as critical to the well-being of humanity and the character of being human.',
'Table of contents\r\n\r\nIntroduction: Human rights and international order 	 1\r\nMichael W. Doyle and Anne-Marie Gardner\r\nPart 1: The construction of human rights at the domestic level\r\n1 On the relationships between civil and political rights, and\r\nsocial and economic rights	23\r\n2 The incorporation of civic and social rights in domestic law 	 56\r\nPart 2: The practice of human rights at the regional level\r\n3 Comparative practice on human rights: North-South 	 89\r\n4 Human rights and Asian values	116\r\n','87.9' );
	insert into books(`title`, `language`, `summary`, `tableofcontents` ,`price`) values
	('Van Gogh','English', 
'Vincent Willem van Gogh was a Dutch Post-Impressionist painter who is among the most famous and influential figures in the history of Western art. ',
'Table of contents\r\n\r\nEARLY PERIOD 1881-1885	9\r\nPARIS, 1885-1888	12\r\nARLES, 1888-1889	32\r\nSAINT-REMY, 1889-1890	44\r\nAUVERS, 1890	86\r\n','87.9' );

	insert into booksauthor (bookid, author) values (1,'Shakespeare'),
(2,'J.K. Rowling'),(3,'Herman Melville'),(4,'C.S. Lewis'),
(5,'Alexandre Dumas'),(6,'Lev Tolstoy'),(7,'Jess Rollins'),(8,'Stephen Hawking'),
(9,'Jean-Marc Coicaud'),(9,'Michael W. Doyle'),(9,'Anne-Marie Gardner'),(10,'Daniele Catton Rich');

	insert into categories (category, genre) values ('Fiction','Drama' ), ('Fiction','Humor'),
('Fiction','Adventure'),('Fiction','Fantasy'),('Fiction','Novel'),('Fiction','Poetry'),
('Non Fiction','Biografy'),('Non Fiction','Parenthood'),('Non Fiction','Food'), ('Non Fiction','Travel'),
('Non Fiction','Religion'),('Non Fiction','Animals'),('Non Fiction','Future'),('Non Fiction','Universe'),('Non Fiction','Human Rights'),
('Training','Recipes'),('Traning','Games'),('Traning','Travenilg'),('Traning','Health'),('Traning','Business'),('Training','Pets'),
('Science','Biology'),('Science','Anthropology'),('Science','Engineering'), ('Science','Medicine'),('Science','Psycology'),
('Science','Politics'), ('Science','Environment'),
('Science','Space'),
('Culture','Music'),('Culture','Art'),('Culture','Dance'),('Culture','Cinema');

	insert into bookgenre(bookid, genre) values (1,'Poetry'),(2,'Fantasy'),(3,'Novel'),(4,'Fantasy'),
(5,'Novel'),(6,'Drama'),(7,'Pets'),(7,'Animals'),(8,'Space'),(8,'Universe'),
(9,'Humal Rights'),(9,'Politics'),(10,'Biography'),(10,'Art');

insert into keywords (bookid, keyword) values (1,'Shakespeare'), (1,'Hamlet'), (1,'Denmark'),(1,'Revenge'),(1,'Obsession'),(1,'Play');

insert into keywords (bookid, keyword) values (2,'Fairy tale'), (2,'Children'),(2,'England'),(2,'Wizards'),(2,'Family');

insert into keywords (bookid, keyword) values (3,'Symbolism'),(3,'Sea'),(3,'Whale'), (3,'Hunting'),(3,'Novel');

insert into keywords (bookid, keyword) values (4,'England'), (4,'Children'),(4,'Fairy tale'),(4, 'War'),(4,'Adventure');

insert into keywords (bookid, keyword) values (5,'France 17 century'), (5,'Honor'),(5,'Friendship'),(5,'Adventure'), (5,'Musketeers');

insert into keywords (bookid, keyword) values (6,'Love'), (6,'Russia 19 century'),(6,'Drama');

insert into keywords (bookid, keyword) values (7,'Dogs'),(7,'Training'),(7,'Family');

insert into keywords (bookid, keyword) values (8,'Univers'),(8,'Big Bang'),(8,'Stars'),(8,'Time');

insert into keywords (bookid, keyword) values (9,'Human rights'),(9,'Univers'),(9,'Future');

insert into keywords (bookid, keyword) values (10,'Art'),(10,'Van Gogh');