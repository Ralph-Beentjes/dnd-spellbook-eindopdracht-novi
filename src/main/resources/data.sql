-- Classes
INSERT INTO classes (class_name, description)
VALUES ('Bard', 'An inspiring magician whose power echoes the music of creation.')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO classes (class_name, description)
VALUES ('Cleric', 'A priestly champion who wields divine magic in service of a higher power.')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO classes (class_name, description)
VALUES ('Druid', 'A priest of the Old Faith, wielding the powers of nature and adopting animal forms.')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO classes (class_name, description)
VALUES ('Paladin', 'A holy warrior bound to a sacred oath.')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO classes (class_name, description)
VALUES ('Ranger', 'A master of ranged combat, one with nature.')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO classes (class_name, description)
VALUES ('Sorcerer', 'A magic user who draws their power from within.')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO classes (class_name, description)
VALUES ('Warlock', 'A user of magic that is pacted to a powerful entity.')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO classes (class_name, description)
VALUES ('Wizard', 'A scholarly magic-user who casts spells through study and intelligence.')
    ON CONFLICT (id) DO NOTHING;


-- Spells

INSERT INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description)
VALUES
    ('Fire Bolt', 0, 'ACTION', 120, 'V, S', 'Instantaneous', false, 'You hurl a mote of fire...'),
    ('Mage Hand', 0, 'ACTION', 30, 'V, S', '1 minute', false, 'A spectral hand appears...'),
    ('Prestidigitation', 0, 'ACTION', 10, 'V, S', 'Up to 1 hour', false, 'Minor magical effects...'),
    ('Sacred Flame', 0, 'ACTION', 60, 'V, S', 'Instantaneous', false, 'Radiant flame descends...'),
    ('Guidance', 0, 'ACTION', 0, 'V, S', 'Concentration, up to 1 minute', true, 'Add 1d4 to ability check...'),
    ('Toll the Dead', 0, 'ACTION', 60, 'V, S', 'Instantaneous', false, 'Necrotic bell sound...'),
    ('Vicious Mockery', 0, 'ACTION', 60, 'V', 'Instantaneous', false, 'Insult deals psychic damage...'),
    ('Shillelagh', 0, 'BONUS_ACTION', 0, 'V, S, M', '1 minute', false, 'Weapon becomes magical...'),
    ('Eldritch Blast', 0, 'ACTION', 120, 'V, S', 'Instantaneous', false, 'Beam of force energy...'),
    ('Thunderclap', 0, 'ACTION', 5, 'S', 'Instantaneous', false, 'Thunder burst...'),

    ('Cure Wounds', 1, 'ACTION', 0, 'V, S', 'Instantaneous', false, 'Healing touch...'),
    ('Bless', 1, 'ACTION', 30, 'V, S, M', 'Concentration, up to 1 minute', true, 'Add d4 to rolls...'),
    ('Magic Missile', 1, 'ACTION', 120, 'V, S', 'Instantaneous', false, 'Auto-hit darts...'),
    ('Shield', 1, 'REACTION', 0, 'V, S', '1 round', false, '+5 AC shield...'),
    ('Healing Word', 1, 'BONUS_ACTION', 60, 'V', 'Instantaneous', false, 'Healing at range...'),
    ('Detect Magic', 1, 'ACTION', 0, 'V, S', 'Concentration, up to 10 minutes', true, 'Sense magic...'),
    ('Hex', 1, 'BONUS_ACTION', 90, 'V, S, M', 'Concentration, up to 1 hour', true, 'Curse target...'),
    ('Entangle', 1, 'ACTION', 90, 'V, S', 'Concentration, up to 1 minute', true, 'Restraining vines...'),
    ('Divine Smite', 1, 'ACTION', 0, 'V', 'Instantaneous', false, 'Radiant weapon damage...'),
    ('Dissonant Whispers', 1, 'ACTION', 60, 'V', 'Instantaneous', false, 'Psychic damage...'),
    ('Hunter''s Mark', 1, 'BONUS_ACTION', 90, 'V', 'Concentration, up to 1 hour', true, 'Mark target...'),

    ('Misty Step', 2, 'BONUS_ACTION', 0, 'V', 'Instantaneous', false, 'Teleport...'),
    ('Hold Person', 2, 'ACTION', 60, 'V, S, M', 'Concentration, up to 1 minute', true, 'Paralyze...'),
    ('Scorching Ray', 2, 'ACTION', 120, 'V, S', 'Instantaneous', false, 'Fire rays...'),
    ('Spiritual Weapon', 2, 'BONUS_ACTION', 60, 'V, S', '1 minute', false, 'Floating weapon...'),
    ('Moonbeam', 2, 'ACTION', 120, 'V, S, M', 'Concentration, up to 1 minute', true, 'Radiant beam...'),
    ('Shatter', 2, 'ACTION', 60, 'V, S, M', 'Instantaneous', false, 'Thunder damage...'),
    ('Aid', 2, 'ACTION', 30, 'V, S, M', '8 hours', false, 'HP boost...'),

    ('Fireball', 3, 'ACTION', 150, 'V, S, M', 'Instantaneous', false, 'Explosion...'),
    ('Counterspell', 3, 'REACTION', 60, 'S', 'Instantaneous', false, 'Cancel spell...'),
    ('Mass Healing Word', 3, 'BONUS_ACTION', 60, 'V', 'Instantaneous', false, 'Group heal...'),
    ('Spirit Guardians', 3, 'ACTION', 0, 'V, S, M', 'Concentration, up to 10 minutes', true, 'Spirits attack...'),
    ('Call Lightning', 3, 'ACTION', 120, 'V, S', 'Concentration, up to 10 minutes', true, 'Lightning strike...'),
    ('Hypnotic Pattern', 3, 'ACTION', 120, 'V, S, M', 'Concentration, up to 1 minute', true, 'Charm pattern...'),
    ('Hunger of Hadar', 3, 'ACTION', 150, 'V, S, M', 'Concentration, up to 1 minute', true, 'Void sphere...'),
    ('Conjure Animals', 3, 'ACTION', 60, 'V, S', 'Concentration, up to 1 hour', true, 'Summon beasts...'),

    ('Banishment', 4, 'ACTION', 60, 'V, S, M', 'Concentration, up to 1 minute', true, 'Exile target...'),
    ('Arcane Eye', 4, 'ACTION', 30, 'V, S, M', 'Concentration, up to 1 hour', true, 'Invisible eye...'),
    ('Guardian of Faith', 4, 'ACTION', 30, 'V', '8 hours', false, 'Guardian spirit...'),
    ('Polymorph', 4, 'ACTION', 60, 'V, S, M', 'Concentration, up to 1 hour', true, 'Transform...'),
    ('Blight', 4, 'ACTION', 30, 'V, S', 'Instantaneous', false, 'Necrotic damage...'),
    ('Dominate Beast', 4, 'ACTION', 60, 'V, S', 'Concentration, up to 1 minute', true, 'Control beast...'),

    ('Cone of Cold', 5, 'ACTION', 0, 'V, S, M', 'Instantaneous', false, 'Cold cone...'),
    ('Scrying', 5, 'ACTION', 0, 'V, S, M', 'Concentration, up to 10 minutes', true, 'Remote viewing...'),
    ('Mass Cure Wounds', 5, 'ACTION', 60, 'V, S', 'Instantaneous', false, 'Group heal...'),
    ('Dominate Person', 5, 'ACTION', 60, 'V, S', 'Concentration, up to 1 minute', true, 'Control humanoid...'),
    ('Wrath of Nature', 5, 'ACTION', 120, 'V, S', 'Concentration, up to 1 minute', true, 'Nature attacks...'),
    ('Destructive Wave', 5, 'ACTION', 0, 'V', 'Instantaneous', false, 'Shockwave...'),

    ('Chain Lightning', 6, 'ACTION', 150, 'V, S, M', 'Instantaneous', false, 'Lightning chain...'),
    ('Harm', 6, 'ACTION', 60, 'V, S', 'Instantaneous', false, 'Necrotic damage...'),
    ('Investiture of Flame', 6, 'ACTION', 0, 'V, S', 'Concentration, up to 10 minutes', true, 'Fire aura...'),
    ('Otto''s Irresistible Dance', 6, 'ACTION', 30, 'V', 'Concentration, up to 1 minute', true, 'Forced dance...'),

    ('Finger of Death', 7, 'ACTION', 60, 'V, S', 'Instantaneous', false, 'Kill spell...'),
    ('Resurrection', 7, 'ACTION', 0, 'V, S, M', 'Instantaneous', false, 'Revive...'),
    ('Etherealness', 7, 'ACTION', 0, 'V, S', '8 hours', false, 'Enter ethereal plane...'),
    ('Mordenkainen''s Sword', 7, 'ACTION', 60, 'V, S, M', 'Concentration, up to 1 minute', true, 'Magic sword...'),

    ('Sunburst', 8, 'ACTION', 150, 'V, S, M', 'Instantaneous', false, 'Radiant burst...'),
    ('Power Word Stun', 8, 'ACTION', 60, 'V', 'Instantaneous', false, 'Stun target...'),
    ('Earthquake', 8, 'ACTION', 500, 'V, S, M', 'Concentration, up to 1 minute', true, 'Massive quake...'),
    ('Holy Aura', 8, 'ACTION', 0, 'V, S, M', 'Concentration, up to 1 minute', true, 'Divine aura...'),

    ('Wish', 9, 'ACTION', 0, 'V', 'Instantaneous', false, 'Reality bending...'),
    ('Mass Heal', 9, 'ACTION', 60, 'V, S', 'Instantaneous', false, 'Mass healing...'),
    ('Foresight', 9, 'ACTION', 0, 'V, S, M', '8 hours', false, 'Future vision...'),
    ('True Polymorph', 9, 'ACTION', 30, 'V, S, M', 'Concentration, up to 1 hour', true, 'Permanent transform...'),
    ('Storm of Vengeance', 9, 'ACTION', 0, 'V, S', 'Concentration, up to 1 minute', true, 'Mass storm...')
    ON CONFLICT (spell_name) DO NOTHING;

-- Class - Spell Links

-- Bard
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Bard'), (SELECT id FROM spells WHERE spell_name = 'Vicious Mockery')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Bard'), (SELECT id FROM spells WHERE spell_name = 'Prestidigitation')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Bard'), (SELECT id FROM spells WHERE spell_name = 'Mage Hand')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Bard'), (SELECT id FROM spells WHERE spell_name = 'Healing Word')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Bard'), (SELECT id FROM spells WHERE spell_name = 'Dissonant Whispers')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Bard'), (SELECT id FROM spells WHERE spell_name = 'Detect Magic')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Bard'), (SELECT id FROM spells WHERE spell_name = 'Misty Step')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Bard'), (SELECT id FROM spells WHERE spell_name = 'Shatter')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Bard'), (SELECT id FROM spells WHERE spell_name = 'Hold Person')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Bard'), (SELECT id FROM spells WHERE spell_name = 'Hypnotic Pattern')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Bard'), (SELECT id FROM spells WHERE spell_name = 'Polymorph')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Bard'), (SELECT id FROM spells WHERE spell_name = 'Dominate Person')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Bard'), (SELECT id FROM spells WHERE spell_name = 'Otto''s Irresistible Dance')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Bard'), (SELECT id FROM spells WHERE spell_name = 'Etherealness')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Bard'), (SELECT id FROM spells WHERE spell_name = 'True Polymorph')) ON CONFLICT DO NOTHING;

-- Cleric
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Sacred Flame')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Guidance')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Toll the Dead')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Cure Wounds')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Bless')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Healing Word')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Detect Magic')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Hold Person')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Spiritual Weapon')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Aid')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Mass Healing Word')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Spirit Guardians')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Banishment')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Guardian of Faith')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Mass Cure Wounds')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Harm')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Resurrection')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Sunburst')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Holy Aura')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Mass Heal')) ON CONFLICT DO NOTHING;

-- Druid
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Guidance')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Shillelagh')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Thunderclap')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Cure Wounds')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Detect Magic')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Entangle')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Moonbeam')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Call Lightning')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Conjure Animals')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Polymorph')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Dominate Beast')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Wrath of Nature')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Investiture of Flame')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Earthquake')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Foresight')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Storm of Vengeance')) ON CONFLICT DO NOTHING;

-- Paladin
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Paladin'), (SELECT id FROM spells WHERE spell_name = 'Cure Wounds')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Paladin'), (SELECT id FROM spells WHERE spell_name = 'Bless')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Paladin'), (SELECT id FROM spells WHERE spell_name = 'Detect Magic')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Paladin'), (SELECT id FROM spells WHERE spell_name = 'Divine Smite')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Paladin'), (SELECT id FROM spells WHERE spell_name = 'Misty Step')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Paladin'), (SELECT id FROM spells WHERE spell_name = 'Hold Person')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Paladin'), (SELECT id FROM spells WHERE spell_name = 'Spiritual Weapon')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Paladin'), (SELECT id FROM spells WHERE spell_name = 'Aid')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Paladin'), (SELECT id FROM spells WHERE spell_name = 'Banishment')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Paladin'), (SELECT id FROM spells WHERE spell_name = 'Guardian of Faith')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Paladin'), (SELECT id FROM spells WHERE spell_name = 'Destructive Wave')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Paladin'), (SELECT id FROM spells WHERE spell_name = 'Holy Aura')) ON CONFLICT DO NOTHING;

-- Ranger
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Ranger'), (SELECT id FROM spells WHERE spell_name = 'Detect Magic')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Ranger'), (SELECT id FROM spells WHERE spell_name = 'Entangle')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Ranger'), (SELECT id FROM spells WHERE spell_name = 'Hunter''s Mark')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Ranger'), (SELECT id FROM spells WHERE spell_name = 'Misty Step')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Ranger'), (SELECT id FROM spells WHERE spell_name = 'Conjure Animals')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Ranger'), (SELECT id FROM spells WHERE spell_name = 'Polymorph')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Ranger'), (SELECT id FROM spells WHERE spell_name = 'Scrying')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Ranger'), (SELECT id FROM spells WHERE spell_name = 'Wrath of Nature')) ON CONFLICT DO NOTHING;

-- Sorcerer
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Fire Bolt')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Mage Hand')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Prestidigitation')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Thunderclap')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Magic Missile')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Shield')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Misty Step')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Scorching Ray')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Fireball')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Counterspell')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Polymorph')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Cone of Cold')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Dominate Person')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Chain Lightning')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Power Word Stun')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Wish')) ON CONFLICT DO NOTHING;

-- Warlock
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Warlock'), (SELECT id FROM spells WHERE spell_name = 'Eldritch Blast')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Warlock'), (SELECT id FROM spells WHERE spell_name = 'Prestidigitation')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Warlock'), (SELECT id FROM spells WHERE spell_name = 'Toll the Dead')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Warlock'), (SELECT id FROM spells WHERE spell_name = 'Hex')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Warlock'), (SELECT id FROM spells WHERE spell_name = 'Misty Step')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Warlock'), (SELECT id FROM spells WHERE spell_name = 'Hold Person')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Warlock'), (SELECT id FROM spells WHERE spell_name = 'Hunger of Hadar')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Warlock'), (SELECT id FROM spells WHERE spell_name = 'Banishment')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Warlock'), (SELECT id FROM spells WHERE spell_name = 'Blight')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Warlock'), (SELECT id FROM spells WHERE spell_name = 'Scrying')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Warlock'), (SELECT id FROM spells WHERE spell_name = 'Dominate Person')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Warlock'), (SELECT id FROM spells WHERE spell_name = 'Finger of Death')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Warlock'), (SELECT id FROM spells WHERE spell_name = 'Etherealness')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Warlock'), (SELECT id FROM spells WHERE spell_name = 'Power Word Stun')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Warlock'), (SELECT id FROM spells WHERE spell_name = 'True Polymorph')) ON CONFLICT DO NOTHING;

-- Wizard
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Fire Bolt')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Mage Hand')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Prestidigitation')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Magic Missile')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Shield')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Detect Magic')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Misty Step')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Hold Person')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Scorching Ray')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Fireball')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Counterspell')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Hypnotic Pattern')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Arcane Eye')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Polymorph')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Cone of Cold')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Scrying')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Chain Lightning')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Finger of Death')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Mordenkainen''s Sword')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Power Word Stun')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Wish')) ON CONFLICT DO NOTHING;
INSERT INTO class_spell VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'True Polymorph')) ON CONFLICT DO NOTHING;