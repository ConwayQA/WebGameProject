INSERT INTO items (item_id, rarity, chance, item_description, properties, img_url) VALUES
    (1, 1, 4, 'Potion of Lesser Healing:Use to recover health by 50', 'consumable:1,currentHealth:50', 'https://drive.google.com/uc?id=1eFd4Knyoi0klSudPerzqokqt_Dqfw3nm'),         --id 1
    (2, 1, 4, 'Potion of Lesser Arcana:Use to recover mana by 50', 'consumable:1,currentMana:50', 'https://drive.google.com/uc?id=1_gT3YPNsECA4mQHqwbUa-db2hu3XmQGm'),
    (3, 1, 1, 'Potion of Basic Healing:Use to recover health by 150', 'consumable:1,currentHealth:150', 'https://drive.google.com/uc?id=1JjxNddoZkJI_UFcyH50rBu-JjBUI9OtK'),
    (4, 1, 1, 'Potion of Basic Arcana:Use to recover mana by 150', 'consumable:1,currentMana:150', 'https://drive.google.com/uc?id=1iHvsTOZ8VXaR6njy7hQhW9ti2BOjUm5d'),
    (5, 2, 4, 'Potion of Healing:Use to recover health by 300', 'consumable:1,currentHealth:300', 'https://drive.google.com/uc?id=1KptH0KJfflS9-1iVC9Ha1t6NSwgJLG_u'),              --id 5
    (6, 2, 4, 'Potion of Arcana:Use to recover mana by 300', 'consumable:1,currentMana:300', 'https://drive.google.com/uc?id=1bytI_fkD_UHXumINi-KpvjdGWDsPPHiz'),
    (7, 2, 1, 'Potion of Greater Healing:Use to recover health by 500', 'consumable:1,currentHealth:500', 'https://drive.google.com/uc?id=1SpZo9k7VdzfCLK5atfxLbQcj0bWHDS8M'),
    (8, 2, 1, 'Potion of Greater Arcana:Use to recover mana by 500', 'consumable:1,currentMana:500', 'https://drive.google.com/uc?id=1rIgMPqS3Si2t3qNH7c8oUoJwsMCyCA2E'),
    (9, 3, 4, 'Potion of Superior Healing:Use to recover health by 1000', 'consumable:1,currentHealth:1000', 'https://drive.google.com/uc?id=1gXPyP3buqAph0N5hw15EDc24xsfX3Ty5'),
    (10, 3, 4, 'Potion of Superior Arcana:Use to recover mana by 1000', 'consumable:1,currentMana:1000', 'https://drive.google.com/uc?id=1XH1PggkZcA23bhk1ECVTEZOPsgGeBAlQ'),         --id 10
    (11, 3, 1, 'Potion of Powerful Healing:Use to recover health by 1500', 'consumable:1,currentHealth:1500', 'https://drive.google.com/uc?id=1WUCxCS6loG1CSx1Mb3-xxolEuHkWQJl6'),
    (12, 3, 1, 'Potion of Powerful Arcana:Use to recover mana by 1500', 'consumable:1,currentMana:1500', 'https://drive.google.com/uc?id=1D7KDksYxya1jTipUkFBCRopWZhRwqTtJ'),
    (13, 4, 4, 'Potion of Artisan Healing:Use to recover health by 2000', 'consumable:1,currentHealth:2000', 'https://drive.google.com/uc?id=1Nwlhd17qZJribsiHRSQUIjMY3et0Sxce'),
    (14, 4, 4, 'Potion of Artisan Arcana:Use to recover mana by 2000', 'consumable:1,currentMana:2000', 'https://drive.google.com/uc?id=1P0n2ADMj0d1uLmZNAjzHsfQ7m1jjRzCc'),
    (15, 4, 1, 'Potion of Exquisite Healing:Use to recover health by 3000', 'consumable:1,currentHealth:3000', 'https://drive.google.com/uc?id=1Stji7xxS7evTh5lOO9AmX26UHMYIKuCj'),    --id 15
    (16, 4, 1, 'Potion of Exquisite Arcana:Use to recover mana by 3000', 'consumable:1,currentMana:3000', 'https://drive.google.com/uc?id=18E4YDKEsaOkhLkDBpygGHNZSS21mtMJg'),
    (17, 5, 4, 'Potion of Masterful Healing:Use to recover health by 5000', 'consumable:1,currentHealth:5000', 'https://drive.google.com/uc?id=1gJJta-GsOAoUSLTd9GdtN7LOA03PZx4w'),
    (18, 5, 4, 'Potion of Masterful Arcana:Use to recover mana by 5000', 'consumable:1,currentMana:5000', 'https://drive.google.com/uc?id=1-uP4mpukk90IXrFXZWY5y8AReAEngPwo'),
    (19, 5, 1, 'Potion of Ultimate Healing:Use to recover health by 10000', 'consumable:1,currentHealth:10000', 'https://drive.google.com/uc?id=1lEhs6qlVGrbiclF3fkhmdTVcScc454nB'),
    (20, 5, 1, 'Potion of Ultimate Arcana:Use to recover mana by 10000', 'consumable:1,currentMana:10000', 'https://drive.google.com/uc?id=1lRFgfZa9m38d_TF8hj2XRnTyPnvaAaqS'),        --id 20
    (21, 5, 0.5, 'Potion of Divine Healing:Use to recover health to max', 'consumable:1,currentHealth:99999999', 'https://drive.google.com/uc?id=1YZP4HVJAw2E12-9i0uKBHs6wpzHkeBNT'),
    (22, 5, 0.5, 'Potion of Divine Arcana:Use to recover mana to max', 'consumable:1,currentMana:99999999', 'https://drive.google.com/uc?id=1dRdNgVXfFNDESSU6GV2hl6yRGtLe9Of3');
INSERT INTO character_info (character_id, health, experience, current_level, mana) VALUES
    (1, 100, 0, 1, 100),
    (2, 2000, 50000, 70, 2000),
    (3, 570, 10000, 30, 570);
INSERT INTO inventory_items (character_id, item_id, position, charges) VALUES
    (2, 21, 1, 1),
    (2, 10, 2, 1),
    (2, 10, 3, 1),
    (2, 10, 4, 1),
    (2, 10, 5, 1),
    (2, 10, 6, 1),
    (3, 18, 1, 1),
    (3, 19, 2, 1),
    (3, 20, 3, 1);