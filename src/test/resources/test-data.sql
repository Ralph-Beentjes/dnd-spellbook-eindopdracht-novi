-- Classes
MERGE INTO classes (class_name, description) KEY (class_name) VALUES ('Bard', 'An inspiring magician whose power echoes the music of creation.');
MERGE INTO classes (class_name, description) KEY (class_name) VALUES ('Cleric', 'A priestly champion who wields divine magic in service of a higher power.');
MERGE INTO classes (class_name, description) KEY (class_name) VALUES ('Druid', 'A priest of the Old Faith, wielding the powers of nature and adopting animal forms.');
MERGE INTO classes (class_name, description) KEY (class_name) VALUES ('Paladin', 'A holy warrior bound to a sacred oath.');
MERGE INTO classes (class_name, description) KEY (class_name) VALUES ('Ranger', 'A master of ranged combat, one with nature.');
MERGE INTO classes (class_name, description) KEY (class_name) VALUES ('Sorcerer', 'A magic user who draws their power from within.');
MERGE INTO classes (class_name, description) KEY (class_name) VALUES ('Warlock', 'A user of magic that is pacted to a powerful entity.');
MERGE INTO classes (class_name, description) KEY (class_name) VALUES ('Wizard', 'A scholarly magic-user who casts spells through study and intelligence.');

-- Spells
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Fire Bolt', 0, 'ACTION', 120, 'V, S', 'Instantaneous', false, 'You hurl a mote of fire at a creature or object within range.');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Mage Hand', 0, 'ACTION', 30, 'V, S', '1 minute', false, 'A spectral, floating hand appears at a point you choose within range.');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Vicious Mockery', 0, 'ACTION', 60, 'V', 'Instantaneous', false, 'Insult deals psychic damage...');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Sacred Flame', 0, 'ACTION', 60, 'V, S', 'Instantaneous', false, 'Radiant flame descends...');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Guidance', 0, 'ACTION', 0, 'V, S', 'Concentration, up to 1 minute', true, 'Add 1d4 to ability check...');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Eldritch Blast', 0, 'ACTION', 120, 'V, S', 'Instantaneous', false, 'Beam of force energy...');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Shillelagh', 0, 'BONUS_ACTION', 0, 'V, S, M', '1 minute', false, 'Weapon becomes magical...');

MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Cure Wounds', 1, 'ACTION', 0, 'V, S', 'Instantaneous', false, 'Healing touch...');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Magic Missile', 1, 'ACTION', 120, 'V, S', 'Instantaneous', false, 'Auto-hit darts...');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Healing Word', 1, 'BONUS_ACTION', 60, 'V', 'Instantaneous', false, 'Healing at range...');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Hex', 1, 'BONUS_ACTION', 90, 'V, S, M', 'Concentration, up to 1 hour', true, 'Curse target...');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Detect Magic', 1, 'ACTION', 0, 'V, S', 'Concentration, up to 10 minutes', true, 'Sense magic...');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Hunter''s Mark', 1, 'BONUS_ACTION', 90, 'V', 'Concentration, up to 1 hour', true, 'Mark target...');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Divine Smite', 1, 'ACTION', 0, 'V', 'Instantaneous', false, 'Radiant weapon damage...');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Entangle', 1, 'ACTION', 90, 'V, S', 'Concentration, up to 1 minute', true, 'Restraining vines...');

MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Misty Step', 2, 'BONUS_ACTION', 0, 'V', 'Instantaneous', false, 'Teleport...');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Hold Person', 2, 'ACTION', 60, 'V, S, M', 'Concentration, up to 1 minute', true, 'Paralyze...');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Scorching Ray', 2, 'ACTION', 120, 'V, S', 'Instantaneous', false, 'Fire rays...');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Spiritual Weapon', 2, 'BONUS_ACTION', 60, 'V, S', '1 minute', false, 'Floating weapon...');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Moonbeam', 2, 'ACTION', 120, 'V, S, M', 'Concentration, up to 1 minute', true, 'Radiant beam...');

MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Fireball', 3, 'ACTION', 150, 'V, S, M', 'Instantaneous', false, 'Explosion...');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Counterspell', 3, 'REACTION', 60, 'S', 'Instantaneous', false, 'Cancel spell...');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Spirit Guardians', 3, 'ACTION', 0, 'V, S, M', 'Concentration, up to 10 minutes', true, 'Spirits attack...');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Conjure Animals', 3, 'ACTION', 60, 'V, S', 'Concentration, up to 1 hour', true, 'Summon beasts...');

MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Polymorph', 4, 'ACTION', 60, 'V, S, M', 'Concentration, up to 1 hour', true, 'Transform...');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Banishment', 4, 'ACTION', 60, 'V, S, M', 'Concentration, up to 1 minute', true, 'Exile target...');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Blight', 4, 'ACTION', 30, 'V, S', 'Instantaneous', false, 'Necrotic damage...');

MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Dominate Person', 5, 'ACTION', 60, 'V, S', 'Concentration, up to 1 minute', true, 'Control humanoid...');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Mass Cure Wounds', 5, 'ACTION', 60, 'V, S', 'Instantaneous', false, 'Group heal...');
MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Scrying', 5, 'ACTION', 0, 'V, S, M', 'Concentration, up to 10 minutes', true, 'Remote viewing...');

MERGE INTO spells (spell_name, level, casting_time, range, components, duration, concentration, description) KEY (spell_name) VALUES ('Wish', 9, 'ACTION', 0, 'V', 'Instantaneous', false, 'Reality bending...');

-- Class - Spell Links

-- Bard
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Bard'), (SELECT id FROM spells WHERE spell_name = 'Vicious Mockery'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Bard'), (SELECT id FROM spells WHERE spell_name = 'Mage Hand'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Bard'), (SELECT id FROM spells WHERE spell_name = 'Healing Word'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Bard'), (SELECT id FROM spells WHERE spell_name = 'Detect Magic'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Bard'), (SELECT id FROM spells WHERE spell_name = 'Misty Step'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Bard'), (SELECT id FROM spells WHERE spell_name = 'Hold Person'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Bard'), (SELECT id FROM spells WHERE spell_name = 'Polymorph'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Bard'), (SELECT id FROM spells WHERE spell_name = 'Dominate Person'));

-- Cleric
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Sacred Flame'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Guidance'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Cure Wounds'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Healing Word'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Detect Magic'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Hold Person'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Spiritual Weapon'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Spirit Guardians'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Banishment'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Cleric'), (SELECT id FROM spells WHERE spell_name = 'Mass Cure Wounds'));

-- Druid
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Guidance'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Shillelagh'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Cure Wounds'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Detect Magic'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Entangle'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Moonbeam'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Conjure Animals'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Druid'), (SELECT id FROM spells WHERE spell_name = 'Polymorph'));

-- Paladin
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Paladin'), (SELECT id FROM spells WHERE spell_name = 'Cure Wounds'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Paladin'), (SELECT id FROM spells WHERE spell_name = 'Detect Magic'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Paladin'), (SELECT id FROM spells WHERE spell_name = 'Divine Smite'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Paladin'), (SELECT id FROM spells WHERE spell_name = 'Misty Step'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Paladin'), (SELECT id FROM spells WHERE spell_name = 'Hold Person'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Paladin'), (SELECT id FROM spells WHERE spell_name = 'Spiritual Weapon'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Paladin'), (SELECT id FROM spells WHERE spell_name = 'Banishment'));

-- Ranger
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Ranger'), (SELECT id FROM spells WHERE spell_name = 'Detect Magic'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Ranger'), (SELECT id FROM spells WHERE spell_name = 'Entangle'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Ranger'), (SELECT id FROM spells WHERE spell_name = 'Hunter''s Mark'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Ranger'), (SELECT id FROM spells WHERE spell_name = 'Misty Step'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Ranger'), (SELECT id FROM spells WHERE spell_name = 'Conjure Animals'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Ranger'), (SELECT id FROM spells WHERE spell_name = 'Scrying'));

-- Sorcerer
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Fire Bolt'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Mage Hand'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Magic Missile'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Misty Step'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Scorching Ray'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Fireball'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Counterspell'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Polymorph'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Dominate Person'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Sorcerer'), (SELECT id FROM spells WHERE spell_name = 'Wish'));

-- Warlock
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Warlock'), (SELECT id FROM spells WHERE spell_name = 'Eldritch Blast'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Warlock'), (SELECT id FROM spells WHERE spell_name = 'Hex'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Warlock'), (SELECT id FROM spells WHERE spell_name = 'Misty Step'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Warlock'), (SELECT id FROM spells WHERE spell_name = 'Hold Person'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Warlock'), (SELECT id FROM spells WHERE spell_name = 'Banishment'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Warlock'), (SELECT id FROM spells WHERE spell_name = 'Blight'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Warlock'), (SELECT id FROM spells WHERE spell_name = 'Scrying'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Warlock'), (SELECT id FROM spells WHERE spell_name = 'Dominate Person'));

-- Wizard
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Fire Bolt'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Mage Hand'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Magic Missile'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Detect Magic'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Misty Step'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Hold Person'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Scorching Ray'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Fireball'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Counterspell'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Polymorph'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Scrying'));
MERGE INTO class_spell (class_id, spell_id) KEY (class_id, spell_id) VALUES ((SELECT id FROM classes WHERE class_name = 'Wizard'), (SELECT id FROM spells WHERE spell_name = 'Wish'));