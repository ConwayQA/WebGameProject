INSERT INTO items (rarity, chance, item_description, properties) VALUES
    (1, 4, 'Potion of Lesser Healing:Use to recover health by 50', 'consumable:1,currentHealth:50'),         --id 1
    (1, 4, 'Potion of Lesser Arcana:Use to recover mana by 50', 'consumable:1,currentMana:50'),
    (1, 1, 'Potion of Basic Healing:Use to recover health by 150', 'consumable:1,currentHealth:150'),
    (1, 1, 'Potion of Basic Arcana:Use to recover mana by 150', 'consumable:1,currentMana:150'),
    (2, 4, 'Potion of Healing:Use to recover health by 300', 'consumable:1,currentHealth:300'),              --id 5
    (2, 4, 'Potion of Arcana:Use to recover mana by 300', 'consumable:1,currentMana:300'),
    (2, 1, 'Potion of Greater Healing:Use to recover health by 500', 'consumable:1,currentHealth:500'),
    (2, 1, 'Potion of Greater Arcana:Use to recover mana by 500', 'consumable:1,currentMana:500'),
    (3, 4, 'Potion of Superior Healing:Use to recover health by 1000', 'consumable:1,currentHealth:1000'),
    (3, 4, 'Potion of Superior Arcana:Use to recover mana by 1000', 'consumable:1,currentMana:1000'),         --id 10
    (3, 1, 'Potion of Powerful Healing:Use to recover health by 1500', 'consumable:1,currentHealth:1500'),
    (3, 1, 'Potion of Powerful Arcana:Use to recover mana by 1500', 'consumable:1,currentMana:1500'),
    (4, 4, 'Potion of Artisan Healing:Use to recover health by 2000', 'consumable:1,currentHealth:2000'),
    (4, 4, 'Potion of Artisan Arcana:Use to recover mana by 2000', 'consumable:1,currentMana:2000'),
    (4, 1, 'Potion of Exquisite Healing:Use to recover health by 3000', 'consumable:1,currentHealth:3000'),    --id 15
    (4, 1, 'Potion of Exquisite Arcana:Use to recover mana by 3000', 'consumable:1,currentMana:3000'),
    (5, 4, 'Potion of Masterful Healing:Use to recover health by 5000', 'consumable:1,currentHealth:5000'),
    (5, 4, 'Potion of Masterful Arcana:Use to recover mana by 5000', 'consumable:1,currentMana:5000'),
    (5, 1, 'Potion of Ultimate Healing:Use to recover health by 10000', 'consumable:1,currentHealth:10000'),
    (5, 1, 'Potion of Ultimate Arcana:Use to recover mana by 10000', 'consumable:1,currentMana:10000'),        --id 20
    (5, 0.5, 'Potion of Divine Healing:Use to recover health to max', 'consumable:1,currentHealth:99999999'),
    (5, 0.5, 'Potion of Divine Arcana:Use to recover mana to max', 'consumable:1,currentMana:99999999');
INSERT INTO character_info (health, experience, current_level, mana) VALUES
    (100, 0, 1, 100),
    (2000, 50000, 70, 2000),
    (570, 10000, 30, 570);
INSERT INTO inventory_items (character_id, item_id, position, charges) VALUES
    (2, 21, 1, 1),
    (2, 10, 2, 1),
    (2, 10, 2, 1),
    (2, 10, 2, 1),
    (2, 10, 2, 1),
    (2, 10, 2, 1),
    (3, 18, 1, 1),
    (3, 19, 2, 1),
    (3, 20, 3, 1);